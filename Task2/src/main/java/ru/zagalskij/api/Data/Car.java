package ru.zagalskij.api.Data;

public class Car extends AToy{
    String model;

    public Car(String name, float price, int frequency, String model) {
        super(name, price, frequency);
        this.model = model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    public String getTypeAttribute() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}
