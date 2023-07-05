package presenter;

import model.Service;
import model.Toy;
import view.View;

import java.util.HashMap;
import java.util.LinkedList;

public class Presenter {
    private Service service;
    private View view;

    public Presenter (View view, Service service) {
        this.service = service;
        this.view = view;
    }

    public void addToyToShop (String nameToy, Integer countToy, Integer frequencyToy) {
        service.addToyToShop(new Toy(nameToy, countToy, frequencyToy));
    }

    public Integer totalToysUnits () {
        return service.totalToysUnits();
    }

    public Integer makePrize() {
        int idToy = service.generatePrizeToy(); // сгенерировать id игрушки
        if (service.presentationPrize(idToy))
                return idToy;
            else
                return 0;
    }

    public String getNameToyByID (Integer id) {
        return service.getNameToyByID(id);
    }

    public LinkedList<String> getHistoryPrize () {
        return service.getPrizeCollectionId();
    }

    public String showAllToys () {
        return service.getFullInfoAboutToys();
    }

    public void updateToy(Integer id,String newName, Integer newCount, Integer newFrequency) {
        service.updateToy(id, newName, newCount, newFrequency);
    }

    public void deleteToy(Integer id) {
        service.deleteToy(id);
    }

    public void generateMinimalToys () {
        service.addToyToShop(new Toy("Плюшевый мишка", 2, 10));
        service.addToyToShop(new Toy("Машинка на радиоуправлении", 1, 30));
        service.addToyToShop(new Toy("Настольный хоккей", 2, 40));
        service.addToyToShop(new Toy("Кукольный домик", 1, 55));
        service.addToyToShop(new Toy("Футбольный мяч", 1, 75));
    }

    public HashMap<String, String> getToyMapById (Integer id) {
        return service.getToyMapById(id);
    }
}
