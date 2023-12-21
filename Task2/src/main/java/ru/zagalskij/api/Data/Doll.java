package ru.zagalskij.api.Data;

public class Doll extends AToy {
    private String material;
    public Doll(String name, float price, int frequency, String material) {
        super(name,price,frequency);
        this.material = material;
    }
}
