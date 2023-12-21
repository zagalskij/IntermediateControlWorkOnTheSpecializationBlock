package ru.zagalskij.api.Data;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private String name;
    private List<AToy> listAtoy;

    public ToyStore(String name) {
        this.name = name;
        this.listAtoy = new ArrayList<>();
    }
    public void addToy(AToy atoy){
        listAtoy.add(atoy);
    }

    public String getName() {
        return name;
    }

    public List<AToy> getListAtoy() {
        return listAtoy;
    }
}
