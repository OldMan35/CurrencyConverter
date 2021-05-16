package ru.currencyconverter.model;

public class Valute {
    private String id; //"AUD" etc.
    private String value; //57.2883

    public Valute() {

    }

    public Valute(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }
}
