package ru.zagalskij.api.Data;

public class Designer extends AToy{
    private String recommendedAge;


    public Designer(String name, float price, int frequency, String recommendedAge) {
        super(name, price, frequency);
        this.recommendedAge = recommendedAge;
    }

    public void setRecommendedAge(String recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public String getRecommendedAge() {
        return recommendedAge;
    }
    public String getTypeAttribute() {
        return recommendedAge;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "recommendedAge='" + recommendedAge + '\'' +
                '}';
    }
}
