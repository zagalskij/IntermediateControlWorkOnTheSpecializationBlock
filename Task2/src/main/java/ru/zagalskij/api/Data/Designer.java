package ru.zagalskij.api.Data;

public class Designer extends AToy{
    private String recommendedAge;

    public Designer(String name, float price, int frequency, String recommendedAge) {
        super(name, price, frequency);
        this.recommendedAge = recommendedAge;
    }
}
