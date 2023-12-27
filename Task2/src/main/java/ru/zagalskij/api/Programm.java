package ru.zagalskij.api;

import ru.zagalskij.api.Data.ToyStore;

public class Programm {

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore("Toy Kingdom");
        Presenter presenter = new Presenter();
        presenter.createDatabase(toyStore);
        presenter.ButtonAddToy(toyStore);
        presenter.view.DisplayTheProduct(toyStore);
        presenter.Raffle(toyStore);

    }
    }

