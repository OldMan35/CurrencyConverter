package ru.currencyconverter.model;

public class Valute {

    private double value; //57.2883
    private String idTo;//"AUD" etc.
    private String idFrom;//"EUR" etc.
    private String selectFirstCurrency;
    private String selectSecondCurrency;

    public Valute() {

    }

    public String getSelectFirstCurrency() {
        return selectFirstCurrency;
    }

    public void setSelectFirstCurrency(String selectFirstCurrency) {
        this.selectFirstCurrency = selectFirstCurrency;
    }

    public String getSelectSecondCurrency() {
        return selectSecondCurrency;
    }

    public void setSelectSecondCurrency(String selectSecondCurrency) {
        this.selectSecondCurrency = selectSecondCurrency;
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
