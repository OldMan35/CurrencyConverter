package ru.currencyconverter.model;

public class Valute {
    private String idFrom; //"AUD" etc.
    private String idTo;//"EUR" etc.
    private double value; //57.2883

    public Valute() {

    }

    public String getIdFrom() {

        return this.idFrom;
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

    public String getIdTo() {

        return idTo;
    }

    public void setIdTo(String idTo) {

        this.idTo = idTo;
    }

    @Override
    public String toString() {
        return "Valute{" +
                "idFrom='" + idFrom + '\'' +
                ", idTo='" + idTo + '\'' +
                ", value=" + value +
                '}';
    }
}
