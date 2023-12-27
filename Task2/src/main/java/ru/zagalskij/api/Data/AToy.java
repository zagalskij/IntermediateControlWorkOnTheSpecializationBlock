package ru.zagalskij.api.Data;

public abstract class AToy {
   private static int nextId = 1;
   private int id;
   private String name;
   private float price;
   private int frequency;
   public abstract String getTypeAttribute();


   public float getPrice() {
      return price;
   }

   public int getFrequency() {
      return frequency;
   }


   public AToy(String name, float price, int frequency, int countToy) {
      this.name = name;
      this.price = price;
      this.frequency = frequency;
      this.id=nextId++;
   }


   public static void setNextId(int nextId) {
      AToy.nextId = nextId;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public void setFrequency(int frequency) {
      this.frequency = frequency;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   @Override
   public String toString() {
      return "AToy{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", price=" + price +
              ", frequency=" + frequency +
              '}';
   }
}

