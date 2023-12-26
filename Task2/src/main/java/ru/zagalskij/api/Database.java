package ru.zagalskij.api;

import ru.zagalskij.api.Data.*;

import java.io.*;

public class Database {
    private String databaseFileName;
    private ToyStore toyStore;

    public Database(String databaseFileName, ToyStore toyStore) {
        this.databaseFileName = databaseFileName;
        this.toyStore = toyStore;
    }


    public void saveToyToDatabase(AToy atoy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFileName, true))) {
            String line = buildLineFromToy(atoy);
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildLineFromToy(AToy atoy) {
        String type = atoy.getClass().getSimpleName();
        String attribute;
        if (atoy instanceof Car) {
            attribute = ((Car) atoy).getModel();
        } else if (atoy instanceof Designer) {
            attribute = ((Designer) atoy).getRecommendedAge();
        } else if (atoy instanceof Doll) {
            attribute = ((Doll) atoy).getMaterial();
        } else {
            throw new IllegalArgumentException("Unknown toy type: " + type);
        }
        return String.format("%s,%.2f,%d,%d,%s,%s",
                atoy.getName(), atoy.getPrice(), atoy.getFrequency(), atoy.getCountToy(), type, attribute);
    }

}
