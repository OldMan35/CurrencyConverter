package ru.currencyconverter.model;

public class Valute {

    private double value; //57.2883
    private String idTo;//"AUD" etc.
    private String idFrom;//"EUR" etc.

    public Valute() {

    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }

    public double getValue() {

        return value;
    }

    public void setValue(double value) {

        this.value = value;
    }
}
