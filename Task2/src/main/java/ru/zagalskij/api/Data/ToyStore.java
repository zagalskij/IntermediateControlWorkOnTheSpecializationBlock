package ru.zagalskij.api.Data;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import static ru.zagalskij.api.Database.buildLineFromToy;
import static ru.zagalskij.api.Database.createToyFromLine;

public class ToyStore {
    private AToy atoy;
    private  List<Car> listCar;
    private  List<Designer> listDesigner;
    private  List<Doll> listDoll;
    private String name;
    private List<AToy> listAtoy;
    private List<AToy> prizeToys = new ArrayList<>();
    private AToy prizeToy;

    public List<AToy> getPrizeToys() {
        return prizeToys;
    }

    public ToyStore(String name) {
        this.name = name;
        this.listAtoy = new ArrayList<>();
    }
    public AToy selectPrizeToy(int id) {

        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                this.prizeToy = toy;
                break;
            }
        }
        if (this.prizeToy != null) {
            listAtoy.remove(this.prizeToy);
            prizeToys.add(this.prizeToy);
            System.out.println("Prize toy selected: " + this.prizeToy.getName());
        } else {
            System.out.println("No toy with id " + id + " available to select as a prize.");
        }

        return this.prizeToy;
    }
    public void addToy(AToy atoy){
        listAtoy.add(atoy);
    }
    public AToy getCurrentPrizeToy() {
        return prizeToy;
    }

    public void getPrizeToy() {
        try (BufferedReader reader = new BufferedReader(new FileReader("prize toys.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                AToy toy = createToyFromLine(line);
                if (toy != null) {
                    this.prizeToys.add(toy);
                }
            }

            if (!this.prizeToys.isEmpty()) {
                this.prizeToy = this.prizeToys.get(0);
                for (AToy toy : this.prizeToys) {
                    if (toy.getFrequency() > this.prizeToy.getFrequency()) {
                        this.prizeToy = toy;
                    }
                }

                this.prizeToys.remove(this.prizeToy); // Remove the selected prize toy from the list
                System.out.println("You received a prize toy: " + this.prizeToy.getName());
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize toys.txt"))) {
                    for (AToy updatedToy : this.prizeToys) {
                        String updatedLine = buildLineFromToy(updatedToy);
                        writer.write(updatedLine);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No prize toys available to receive.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editToy(int id, String newName, float newPrice, int newFrequency, String newAttribute) {
        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                if (toy instanceof Car) {
                    Car car = (Car) toy;
                    car.setName(newName);
                    car.setPrice(newPrice);
                    car.setFrequency(newFrequency);
                    car.setModel(newAttribute);
                } else if (toy instanceof Designer) {
                    Designer designer = (Designer) toy;
                    designer.setName(newName);
                    designer.setPrice(newPrice);
                    designer.setFrequency(newFrequency);
                    designer.setRecommendedAge(newAttribute);
                } else if (toy instanceof Doll) {
                    Doll doll = (Doll) toy;
                    doll.setName(newName);
                    doll.setPrice(newPrice);
                    doll.setFrequency(newFrequency);
                    doll.setMaterial(newAttribute);
                }
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<AToy> getListAtoy() {
        return listAtoy;
    }
    public AToy getToyTypeById(int id) {
        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null; // Игрушка с указанным id не найдена
    }
}

