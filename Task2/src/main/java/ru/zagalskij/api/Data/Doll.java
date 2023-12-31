package ru.zagalskij.api.Data;

public class Doll extends AToy {
    private String material;

    public Doll(String name, float price, int frequency, String material) {
        super(name, price, frequency);
        this.material = material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
    public String getTypeAttribute() {
        return material;
    }
    @Override
    public String toString() {
        return "Doll{" +
                "material='" + material + '\'' +
                '}';
    }
}
