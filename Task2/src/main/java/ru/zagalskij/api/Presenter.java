package ru.zagalskij.api;

import ru.zagalskij.api.Data.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Presenter {
    private final View view = new View();
    private ToyStore toyStore;
    private Database database;
    private AToy toy;
    AToy prizeToy = null;

    public void CreateStore() {
        String toyStoreName = view.getString("Enter the name store:\n");
        this.toyStore = new ToyStore(toyStoreName);
    }

    public void CreateDatabase() {
        database = new Database(toyStore.getName() + ".txt", toyStore);
    }

    public void Raffle() {
       toyStore.getPrizeToy();
        }


    private void AddToyDrawing(){
        int id = view.getValue("Enter id for adding");
        System.out.println(toyStore.getToyTypeById(id));
        toyStore.selectPrizeToy(id);
    }


    private void ButtonAddToy() {
        while (true) {
            int choice = view.getValue("Select the type of toy to add:\n" +
                    "1. Car\n" +
                    "2. Designer\n" +
                    "3. Doll\n" +
                    "4. Complete\n");
            if (choice == 4) {
                break; // Выход из цикла, если выбрано завершение
            }
            switch (choice) {
                case 1 -> {
                    Car car = new Car(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getString("Enter the machine model:"));
                    this.toyStore.addToy(car);
                    database.saveToyToDatabase(car);
                }
                case 2 -> {
                    Designer designer = new Designer(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getString("Enter the recommended age:"));
                    this.toyStore.addToy(designer);
                    database.saveToyToDatabase(designer);
                }
                case 3 -> {
                    Doll doll = new Doll(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getString("Enter the doll's material:"));
                    toyStore.addToy(doll);
                    database.saveToyToDatabase(doll);
                }
                default -> throw new IllegalArgumentException("Wrong choice!!!");
            }
        }
    }

    public void ButtonEditToy() {
        int editId = view.getValue("Enter id for edit");
        System.out.println(toyStore.getToyTypeById(editId));
        toyStore.editToy(editId,view.getName(), view.getPrice(), view.getFrequency(),
                view.getString("Enter the new attribute:"));

    }

    public void Menu() {
        while (true) {
            int choice = view.getValue("Select an action:\n" +
                    "1. Upload an existing database\n" +
                    "2. Add a store\n" +
                    "3. Add a toy\n" +
                    "4. Edit tiy\n" +
                    "5. Display thr product in the store\n"+
                    "6. Add toy to prize\n"+
                    "7. Raffle\n"+
                    "8. Complete\n");
            if (choice == 8) {
                break; // Выход из цикла, если выбрано завершение
            }
            switch (choice) {
                case 1 -> {
                    String name = view.getString("Enter the name of database:\n");
                    this.toyStore = new ToyStore(name);
                    this.database = new Database(name + ".txt", this.toyStore);
                    this.database.loadToysFromDatabase(name, this.toyStore);
                }
                case 2 -> {
                    CreateStore();
                    CreateDatabase();
                }
                case 3 -> {
                    ButtonAddToy();
                }
                case 4 -> ButtonEditToy();
                case 5 -> view.DisplayTheProduct(this.toyStore);
                case 6 -> {
                    AddToyDrawing();
                    database.saveToyToDatabase(toyStore.getCurrentPrizeToy());
                }
                case 7 -> Raffle();
                default -> throw new IllegalArgumentException("Wrong choice!!!");
            }
        }

    }
}