package ru.zagalskij.api;

import ru.zagalskij.api.Data.*;

import java.io.*;
import java.util.List;

public class Database {
    private String databaseFileName;
    private ToyStore toyStore;

    public Database() {
    }

    public Database(String databaseFileName, ToyStore toyStore) {
        this.databaseFileName = databaseFileName;
        this.toyStore = toyStore;
    }


    public void saveToysToDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFileName, true))) {
            for (AToy atoy : toyStore.getListAtoy()) {
                String line = buildLineFromToy(atoy);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadToysFromDatabase(String databaseFileName, ToyStore toyStore) {
        try (BufferedReader reader = new BufferedReader(new FileReader(databaseFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                AToy toy = createToyFromLine(line);
                if (toy != null) {
                    toyStore.addToy(toy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private AToy createToyFromLine(String line) {
        String[] parts = line.split("\\s+");


        int id = Integer.parseInt(parts[0].split(":")[1]);
        String name = parts[1].split(":")[1];
        float price = Float.parseFloat(parts[2].split(":")[1].replace(",", "."));
        int frequency = Integer.parseInt(parts[3].split(":")[1]);
        String type = parts[4].split(":")[1];

        String attribute;
        switch (type) {
            case "Car":
                attribute = parts[5].split(":")[1];
                return new Car(name, price, frequency, attribute);
            case "Designer":
                attribute = parts[5].split(":")[1];
                return new Designer(name, price, frequency, attribute);
            case "Doll":
                attribute = parts[5].split(":")[1];
                return new Doll(name, price, frequency, attribute);
            default:
                System.err.println("Unknown toy type: " + type);
                return null;
        }
    }
    private String buildLineFromToy(AToy atoy) {
        String type = atoy.getClass().getSimpleName();
        String attribute;
        String nameAttribute;
        if (atoy instanceof Car) {
            attribute = ((Car) atoy).getModel();
            nameAttribute = "Model:";
        } else if (atoy instanceof Designer) {
            attribute = ((Designer) atoy).getRecommendedAge();
            nameAttribute = "RecommendedAge:";
        } else if (atoy instanceof Doll) {
            attribute = ((Doll) atoy).getMaterial();
            nameAttribute = "Material:";
        } else {
            throw new IllegalArgumentException("Unknown toy type: " + type);
        }
        return String.format("Id:%d Name:%s Price:%.2f Frequency:%d Type:%s %s%s",
                atoy.getId(), atoy.getName(), atoy.getPrice(), atoy.getFrequency(), type,nameAttribute, attribute);
    }
    public void savePrizeToysToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            for (AToy prizeToy : toyStore.getPrizeToys()) {
                String line = String.format("Id:%d Name:%s Price:%.2f Frequency:%d Type:%s %s",
                        prizeToy.getId(), prizeToy.getName(), prizeToy.getPrice(), prizeToy.getFrequency(), prizeToy.getTypeAttribute());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
