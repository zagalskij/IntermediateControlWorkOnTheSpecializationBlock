package ru.zagalskij.api;

import ru.zagalskij.api.Data.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Presenter {
    private View view = new View();
    private ToyStore toyStore;
    private Database database;

    public void CreateStore() {
        String toyStoreName = view.getString("Enter the name store:\n");
        this.toyStore = new ToyStore(toyStoreName);
    }

    public void CreateDatabase() {
        database = new Database(toyStore.getName() + ".txt", toyStore);
    }

    public void Raffle() {
        AToy prizeToy = this.toyStore.selectPrizeToy();
        if (prizeToy != null) {
            System.out.println("Prize Toy Information: " + prizeToy);
        }

        // Получаем призовую игрушку и выводим информацию о ней
        toyStore.getPrizeToy();
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
                case 1:
                    Car car = new Car(view.getName(), view.getPrice(), view.getFrequency(),
                             view.getString("Enter the machine model:"));
                    this.toyStore.addToy(car);
                    break;
                case 2:
                    Designer designer = new Designer(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getString("Enter the recommended age:"));
                    this.toyStore.addToy(designer);
                    break;
                case 3:
                    Doll doll = new Doll(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getString("Enter the doll's material:"));
                    toyStore.addToy(doll);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong choice!!!");
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
                    "1. Add a store\n" +
                    "2. Add a toy\n" +
                    "3. Save in database\n" +
                    "4. Edit toy\n" +
                    "5. Make a drawing\n" +
                    "6. Complete\n");
            if (choice == 6) {
                break; // Выход из цикла, если выбрано завершение
            }
            switch (choice) {
                case 1:
                    CreateStore();
                    CreateDatabase();
                    break;
                case 2:
                    ButtonAddToy();
                    break;
                case 3:
                    database.saveToysToDatabase();
                    break;
                case 4:
                    ButtonEditToy();
                    break;
                case 5:
                    Raffle();
                    break;
                case 6:
                    break;
                default:
                    throw new IllegalArgumentException("Wrong choice!!!");
            }
        }

    }
}