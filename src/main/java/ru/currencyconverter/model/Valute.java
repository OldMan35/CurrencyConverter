package ru.currencyconverter.model;

public class Valute {

    private double value;
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

    public double getValue() {

        return value;
    }

    public void setValue(double value) {

        this.value = value;
    }
}
