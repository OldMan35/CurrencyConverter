package ru.currencyconverter.model;

public class Valute {
    private String id; //"AUD" etc.
    private double value; //57.2883

    public Valute() {

    }

    public Valute(double value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public double getValue() {

        return value;
    }

    public void setValue(double value) {

        this.value = value;
    }
}
