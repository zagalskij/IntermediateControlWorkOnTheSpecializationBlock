package ru.zagalskij.api.Data;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private  List<Car> listCar;
    private  List<Designer> listDesigner;
    private  List<Doll> listDoll;
    private String name;
    private List<AToy> listAtoy;

    public ToyStore(String name) {
        this.name = name;
        this.listAtoy = new ArrayList<>();
    }

    public void addToy(AToy atoy){
        listAtoy.add(atoy);
    }
    public void editToy(int id, String newName, float newPrice, int newFrequency, int newCountToy, String newAttribute) {
        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                if (toy instanceof Car) {
                    Car car = (Car) toy;
                    car.setName(newName);
                    car.setPrice(newPrice);
                    car.setFrequency(newFrequency);
                    car.setCountToy(newCountToy);
                    car.setModel(newAttribute);
                } else if (toy instanceof Designer) {
                    Designer designer = (Designer) toy;
                    designer.setName(newName);
                    designer.setPrice(newPrice);
                    designer.setFrequency(newFrequency);
                    designer.setCountToy(newCountToy);
                    designer.setRecommendedAge(newAttribute);
                } else if (toy instanceof Doll) {
                    Doll doll = (Doll) toy;
                    doll.setName(newName);
                    doll.setPrice(newPrice);
                    doll.setFrequency(newFrequency);
                    doll.setCountToy(newCountToy);
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
    public String getToyTypeById(int id) {
        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                return toy.getClass().getSimpleName();
            }
        }
        return null; // Игрушка с указанным id не найдена
    }
}

