package model.interfaces;

public interface ShopInterface <E extends ItemShop> {
    void addItem(E item);
    void deleteItem(Integer id);
    E getItemById(Integer id);
    void updateItemInfo(Integer id, String newName, Integer newCount, Integer newFrequency);
}
