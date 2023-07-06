package model.interfaces;

public interface ItemShop {
    Integer getFrequency();
    Integer getCountItems();
    boolean useItem();
    String getItemName();
    void setItemName(String itemName);
    void setCountItems(Integer countItems);
    void setFrequency(Integer frequency);
}
