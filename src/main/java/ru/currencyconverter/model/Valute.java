package ru.currencyconverter.model;

public class Valute {
    private String idTo; //"AUD" etc.
    private String idFrom;//"AUD" etc.
    private double value; //57.2883

    public Valute() {

    }

    public Valute(double value) {

        this.value = value;
    }

    public String getIdTo() {

        return idTo;
    }

    public void setIdTo(String idTo) {

        this.idTo = idTo;
    }

    public double getValue() {

        return value;
    }

    public void setValue(double value) {

        this.value = value;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }
}
