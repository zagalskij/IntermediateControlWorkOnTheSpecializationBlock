package ru.zagalskij.api.Data;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private AToy atoy;
    private  List<Car> listCar;
    private  List<Designer> listDesigner;
    private  List<Doll> listDoll;
    private String name;
    private List<AToy> listAtoy;
    private List<AToy> prizeToys = new ArrayList<>();


    public ToyStore(String name) {
        this.name = name;
        this.listAtoy = new ArrayList<>();
    }
    public AToy selectPrizeToy() {
        // Метод для выбора призовой игрушки
        if (!listAtoy.isEmpty()) {
            AToy prizeToy = listAtoy.remove(0); // Получаем первую игрушку из списка
            prizeToys.add(prizeToy); // Добавляем в список призовых игрушек
            // Теперь записываем информацию об этой игрушке в текстовый файл
            System.out.println("Prize toy selected: " + prizeToy.getName());
            return  prizeToy;
        } else {
            System.out.println("No toys available to select as a prize.");
            return null;
        }
    }
    public void addToy(AToy atoy){
        listAtoy.add(atoy);
    }

        public void getPrizeToy() {
            // Метод для получения призовой игрушки
            if (!prizeToys.isEmpty()) {
                AToy prizeToy = prizeToys.remove(0); // Удаляем первую игрушку из списка призовых
                System.out.println("You received a prize toy: " + prizeToy.getName());
                // Тут можно добавить логику для уменьшения количества призовых игрушек, если это необходимо
            } else {
                System.out.println("No prize toys available to receive.");
            }
        }
    public void editToy(int id, String newName, float newPrice, int newFrequency, String newAttribute) {
        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                if (toy instanceof Car) {
                    Car car = (Car) toy;
                    car.setName(newName);
                    car.setPrice(newPrice);
                    car.setFrequency(newFrequency);
                    car.setModel(newAttribute);
                } else if (toy instanceof Designer) {
                    Designer designer = (Designer) toy;
                    designer.setName(newName);
                    designer.setPrice(newPrice);
                    designer.setFrequency(newFrequency);
                    designer.setRecommendedAge(newAttribute);
                } else if (toy instanceof Doll) {
                    Doll doll = (Doll) toy;
                    doll.setName(newName);
                    doll.setPrice(newPrice);
                    doll.setFrequency(newFrequency);
                    doll.setMaterial(newAttribute);
                }
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<AToy> getListAtoy() {
        return listAtoy;
    }
    public AToy getToyTypeById(int id) {
        for (AToy toy : listAtoy) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null; // Игрушка с указанным id не найдена
    }
}

