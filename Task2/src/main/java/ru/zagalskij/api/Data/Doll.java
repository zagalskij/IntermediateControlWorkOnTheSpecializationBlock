package ru.zagalskij.api.Data;

public class Doll extends AToy {
    private String material;

    public Doll(String name, float price, int frequency, int countToy, String material) {
        super(name, price, frequency, countToy);
        this.material = material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
