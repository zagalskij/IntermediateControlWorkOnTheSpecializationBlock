package ru.zagalskij.api;

import ru.zagalskij.api.Data.ToyStore;

import ru.zagalskij.api.Data.AToy;

import java.util.List;

public class View {
    public void DisplayTheProduct1(ToyStore toyStore){
        System.out.println("In the store "+toyStore.getName()+" there is such a product: ");
        List<AToy> toy = toyStore.getListAtoy();
        for (AToy toys: toy) {
            System.out.println(toys.getName());
        }
    }
}
