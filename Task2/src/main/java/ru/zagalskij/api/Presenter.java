package ru.zagalskij.api;

import ru.zagalskij.api.Data.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Presenter {
    View view = new View();
    Database database;
    public ToyStore createStore()

    {
    String toyStoreName = view.getString("Enter the name store");
        return new ToyStore(toyStoreName);
    }
    public void createDatabase(ToyStore toyStore)

    {
       database = new Database(toyStore.getName()+".txt",toyStore);
    }
    public void Raffle(ToyStore toyStore){
        AToy prizeToy = toyStore.selectPrizeToy();
        if (prizeToy != null) {
            System.out.println("Prize Toy Information: " + prizeToy);
        }

        // Получаем призовую игрушку и выводим информацию о ней
        toyStore.getPrizeToy();
    }

    public void ButtonAddToy(ToyStore toyStore){
        while (true) {
            int choice = view.getValue("Select the type of toy to add:\n"+
                    "1. Car\n"+
                    "2. Designer\n"+
                    "3. Doll\n"+
                    "4. Complete\n");
            if (choice == 4) {
                break; // Выход из цикла, если выбрано завершение
            }
            switch (choice) {
                case 1:
                    Car car = new Car(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getCountToy(), view.getString("Enter the machine model:"));
                    toyStore.addToy(car);
                    database.saveToyToDatabase(car);
                    break;
                case 2:
                    Designer designer = new Designer(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getCountToy(), view.getString("Enter the recommended age:"));
                    toyStore.addToy(designer);
                    database.saveToyToDatabase(designer);
                    break;
                case 3:
                    Doll doll = new Doll(view.getName(), view.getPrice(), view.getFrequency(),
                            view.getCountToy(), view.getString("Enter the doll's material:"));
                    toyStore.addToy(doll);
                    database.saveToyToDatabase(doll);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong choice!!!");
            }}
    }
    public void ButtonEditToy(ToyStore toyStore){
        int editId = view.getValue("Enter id for edit");
        System.out.println(toyStore.getToyTypeById(editId));

    }
}