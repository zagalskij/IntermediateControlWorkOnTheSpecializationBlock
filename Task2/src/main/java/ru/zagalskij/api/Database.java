package ru.zagalskij.api;

import ru.zagalskij.api.Data.*;

import java.io.*;

public class Database {
    private String databaseFileName;
    private ToyStore toyStore;

    public Database(String databaseFileName, ToyStore toyStore) {
        this.databaseFileName = databaseFileName;
        this.toyStore = toyStore;
    }


    public void saveToyToDatabase(AToy atoy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFileName, true))) {
            String line = buildLineFromToy(atoy);
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
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
    private void savePrizeToyToFile(AToy prizeToy) {
        // Метод для записи призовой игрушки в текстовый файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            String line = String.format("%s,%.2f,%d,%s",
                    prizeToy.getName(), prizeToy.getPrice(), prizeToy.getFrequency(), prizeToy.getTypeAttribute());
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
