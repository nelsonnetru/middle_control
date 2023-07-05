package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Shop <E extends Toy> {
    private int lastId;
    private HashMap<Integer, E> mapToys;
    private LinkedList<Integer> prizeCollectionId;

    public HashMap<Integer, E> getMapToys() {
        return mapToys;
    }

    public Shop () {
        mapToys = new HashMap<>();
        prizeCollectionId = new LinkedList<>();
        this.lastId = 0;
    }

    public void addToy (E toy) {
        this.lastId++;
        mapToys.put(this.lastId, toy);
    }

    public int getLastId() {
        return lastId;
    }

    public Integer countTypeToys() {
        return mapToys.size();
    }

    public Toy getToyById (Integer id) {
        return mapToys.get(id);
    }

    public boolean takeToy(Integer idToy) {
        return this.getToyById(idToy).useToy();
    }

    public void addUnitToPrizeCollection (Integer id) {
        this.prizeCollectionId.add(id);
    }

    public LinkedList<Integer> getPrizeCollectionId() {
        return prizeCollectionId;
    }

    public String getFullInfoAboutToys () {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, E> entry: mapToys.entrySet()){
            result.append(entry.getKey()).append(". ").append(entry.getValue().getToyName()).append("\n").
                    append("\tКоличество: ").append(entry.getValue().getCountToys()).append("\n").
                    append("\tЧастота выпадения: ").append(entry.getValue().getFrequency()).append("\n\n");
        }
        return result.toString();
    }

    public void updateToyInfo (Integer id, String newName, Integer newCount, Integer newFrequency) {
        Toy toyItem = getToyById(id);
        toyItem.setToyName(newName);
        toyItem.setCountToys(newCount);
        toyItem.setFrequency(newFrequency);
    }

    public void deleteToy (Integer id) {
        mapToys.remove(id);
    }


    @Override
    public String toString() {
        StringBuilder resultStr = new StringBuilder("Shop");
        return resultStr.append(" {\n").append("\tlastId=").append(lastId).append("\n").
                append("\tmapToys={\n").append(mapToys).append("}").toString();
    }
}
