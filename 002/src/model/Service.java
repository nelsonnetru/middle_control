package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Service {
    private Shop<Toy> currentShop;

    public Service (Shop<Toy> shop) {
        this.currentShop = shop;
    }

    public Integer totalToysUnits () {
        Integer totalUnits = 0;
        HashMap<Integer, Toy> mapToys = currentShop.getMapToys();
        for (Map.Entry<Integer, Toy> entry: mapToys.entrySet()){
            totalUnits += entry.getValue().getCountToys();
        }
        return totalUnits;
    }

    public String getNameToyByID (Integer id) {
        return currentShop.getToyById(id).getToyName();
    }

    public void addToyToShop (Toy toy) {
        currentShop.addToy(toy);
    }

    public int generatePrizeToy () {
        int[] indexes = new int[currentShop.countTypeToys()];
        int[] frequences = new int[currentShop.countTypeToys()];

        int x = 0;
        HashMap<Integer, Toy> mapToys = currentShop.getMapToys();
        for (Map.Entry<Integer, Toy> entry: mapToys.entrySet()){
            if (entry.getValue().getCountToys() > 0) {
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
        if (currentShop.takeToy(idToy)) {
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
        return currentShop.getFullInfoAboutToys();
    }

    public void updateToy(Integer id, String newName, Integer newCount, Integer newFrequency) {
        currentShop.updateToyInfo(id, newName, newCount, newFrequency);
    }

    public void deleteToy(Integer id) {
        currentShop.deleteToy(id);
    }

    public HashMap<String, String> getToyMapById (Integer id) {
        HashMap<String, String> result = new HashMap<>();
        result.put("id", id.toString());
        result.put("name", currentShop.getToyById(id).getToyName());
        result.put("count", currentShop.getToyById(id).getCountToys().toString());
        result.put("frequency", currentShop.getToyById(id).getFrequency().toString());
        return result;
    }
}
