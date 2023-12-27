package ru.zagalskij.api;

import ru.zagalskij.api.Data.ToyStore;

import ru.zagalskij.api.Data.AToy;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class View {
    Scanner in = new Scanner(System.in);
    public void DisplayTheProduct(ToyStore toyStore){
        System.out.println("In the store "+toyStore.getName()+" there is such a product: ");
        List<AToy> toy = toyStore.getListAtoy();
        for (AToy toys: toy) {
            System.out.println(toys.getName());
        }
    }
    public int getValue(String title) {
        System.out.printf("%s", title);
        int value = in.nextInt();
        in.nextLine();
        return value;
    }
    public String getString(String title) {
        System.out.printf("%s", title);
        return in.nextLine();
    }
    public String getName(){
        System.out.println("Enter the name of the toy");
        return in.nextLine();
    }
    public float getPrice(){
        System.out.println("Enter the price of the toy");
        return in.nextFloat();
    }
    public int getFrequency(){
        System.out.println("Enter the frequency of falling out of the toy");
        return in.nextInt();
    }
    public int getCountToy(){
        System.out.println("Enter the number of toys to add");
        int value = in.nextInt();
        in.nextLine();
        return value;
    }
}
