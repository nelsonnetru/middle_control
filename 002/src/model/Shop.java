package model;

import model.interfaces.ItemShop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Shop <E extends ItemShop> {
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

    public void addItem(E toy) {
        this.lastId++;
        mapToys.put(this.lastId, toy);
    }

    public int getLastId() {
        return lastId;
    }

    public Integer countTypeItems() {
        return mapToys.size();
    }

    public E getItemById(Integer id) {
        return mapToys.get(id);
    }

    public boolean takeItem(Integer idToy) {
        return this.getItemById(idToy).useItem();
    }

    public void addUnitToPrizeCollection (Integer id) {
        this.prizeCollectionId.add(id);
    }

    public LinkedList<Integer> getPrizeCollectionId() {
        return prizeCollectionId;
    }

    public String getFullInfoAboutItems() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, E> entry: mapToys.entrySet()){
            result.append(entry.getKey()).append(". ").append(entry.getValue().getItemName()).append("\n").
                    append("\tКоличество: ").append(entry.getValue().getCountItems()).append("\n").
                    append("\tЧастота выпадения: ").append(entry.getValue().getFrequency()).append("\n\n");
        }
        return result.toString();
    }

    public void updateItemInfo(Integer id, String newName, Integer newCount, Integer newFrequency) {
        E toyItem = getItemById(id);
        toyItem.setItemName(newName);
        toyItem.setCountItems(newCount);
        toyItem.setFrequency(newFrequency);
    }

    public void deleteItem(Integer id) {
        mapToys.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder resultStr = new StringBuilder("Shop");
        return resultStr.append(" {\n").append("\tlastId=").append(lastId).append("\n").
                append("\tmapToys={\n").append(mapToys).append("}").toString();
    }
}
