package ru.zagalskij.api.Data;

public class Car extends AToy{
    String model;

    public Car(String name, float price, int frequency, int countToy, String model) {
        super(name, price, frequency, countToy);
        this.model = model;
    }
    public Car(String name, float price, int frequency, String model) {
        super(name, price, frequency, 1);
        this.model = model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
