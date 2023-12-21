package ru.zagalskij.api.Data;

public abstract class AToy {
   private static int nextId = 1;
   private int id;
   private String name;
   private float price;
   private int frequency;

   public AToy(String name, float price, int frequency) {
      this.name = name;
      this.price = price;
      this.frequency = frequency;
      this.id=nextId++;
   }

   public String getName() {
      return name;
   }
}
