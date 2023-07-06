package model;

import model.interfaces.ItemShop;

public class Toy implements ItemShop {
    private String toyName;
    private Integer countToys;
    private Integer frequency;

    public Toy (String toyName, Integer countToys, Integer frequency) {
        this.toyName = toyName;
        this.countToys = countToys;
        if (frequency > 100)
            this.frequency = 100;
        else if (frequency < 0)
            this.frequency = 0;
        else
            this.frequency = frequency;
    }

    public Toy (String toyName) {
        this (toyName, 20, 25);
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Integer getCountItems() {
        return countToys;
    }

    public boolean useItem() {
        if (this.countToys == 0) return false;

        this.countToys--;
        return true;
    }

    public String getItemName() {
        return toyName;
    }

    public void setItemName(String toyName) {
        this.toyName = toyName;
    }

    public void setCountItems(Integer countToys) {
        this.countToys = countToys;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        StringBuilder returnStr = new StringBuilder("Toy {\n");
        return returnStr.append("\t\ttoyName=").append(toyName).append("\n").append("\t\tcountToys=").append(countToys).
                append("\n").append("\t\tfrequency=").append(frequency).append("}\n").toString();
    }
}
