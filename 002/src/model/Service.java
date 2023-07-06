package model;

import model.interfaces.ItemShop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Service <E extends ItemShop> {
    private Shop<E> currentShop;

    public Service (Shop<E> shop) {
        this.currentShop = shop;
    }

    public Integer totalToysUnits () {
        Integer totalUnits = 0;
        HashMap<Integer, E> mapToys = currentShop.getMapToys();
        for (Map.Entry<Integer, E> entry: mapToys.entrySet()){
            totalUnits += entry.getValue().getCountItems();
        }
        return totalUnits;
    }

    public String getNameToyByID (Integer id) {
        return currentShop.getItemById(id).getItemName();
    }

    public void addToyToShop (E toy) {
        currentShop.addItem(toy);
    }

    public int generatePrizeToy () {
        int[] indexes = new int[currentShop.countTypeItems()];
        int[] frequences = new int[currentShop.countTypeItems()];

        int x = 0;
        HashMap<Integer, E> mapToys = currentShop.getMapToys();
        for (Map.Entry<Integer, E> entry: mapToys.entrySet()){
            if (entry.getValue().getCountItems() > 0) {
                indexes[x] = entry.getKey();
                frequences[x] = entry.getValue().getFrequency();
                x++;
            }
        }

        int tmp, tmpIndex;
        for (int i = 0; i < frequences.length; i++) // сортировка массива методом пузырька
        {
            for (int j=0; j<(frequences.length-i-1); j++)
            {
                if (frequences[j] > frequences[j+1])
                {
                    tmp = frequences[j];
                    frequences[j] = frequences[j+1];
                    frequences[j+1] = tmp;

                    tmpIndex = indexes[j];
                    indexes[j] = indexes[j+1];
                    indexes[j+1] = tmpIndex;
                }
            }
        }

        Random rand = new Random();
        int number = rand.nextInt(101);

        int Index = 0;
        for (int i = 0; i < indexes.length; i++)
        {
            Index = i;
            if (number <= frequences[i]) break;
        }
        return indexes[Index];
    }

    public boolean presentationPrize (Integer idToy) {
        if (currentShop.takeItem(idToy)) {
            currentShop.addUnitToPrizeCollection(idToy);
            return true;
        }

        return false;
    }

    public LinkedList<String> getPrizeCollectionId () {
        LinkedList<String> result = new LinkedList<>();
        for (Integer item : currentShop.getPrizeCollectionId()) {
            result.add(getNameToyByID(item));
        }
        return result;
    }

    public String getFullInfoAboutToys () {
        return currentShop.getFullInfoAboutItems();
    }

    public void updateToy(Integer id, String newName, Integer newCount, Integer newFrequency) {
        currentShop.updateItemInfo(id, newName, newCount, newFrequency);
    }

    public void deleteToy(Integer id) {
        currentShop.deleteItem(id);
    }

    public HashMap<String, String> getToyMapById (Integer id) {
        HashMap<String, String> result = new HashMap<>();
        result.put("id", id.toString());
        result.put("name", currentShop.getItemById(id).getItemName());
        result.put("count", currentShop.getItemById(id).getCountItems().toString());
        result.put("frequency", currentShop.getItemById(id).getFrequency().toString());
        return result;
    }
}
