package ru.currencyconverter.model;

public class Valute {
    private String id; //"AUD" etc.
    private String name; //"Австралийский доллар"
    private int value; //57.2883

    public Valute() {

    }

    public Valute(String id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
