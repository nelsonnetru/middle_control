package model;

public class Toy {
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

    public Integer getCountToys() {
        return countToys;
    }

    public boolean useToy () {
        if (this.countToys == 0) return false;

        this.countToys--;
        return true;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public void setCountToys(Integer countToys) {
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
