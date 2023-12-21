package ru.zagalskij.api.Data;

public class Car extends AToy{
    String model;
    public Car(String name, float price, int frequency, String model) {
        super(name, price, frequency);
        this.model = model;
    }
}
