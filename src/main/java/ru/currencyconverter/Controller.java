package ru.currencyconverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Controller extends ParserJson {
    private String firstValue;
    private String secondValue;
    private double valueController;
    private String valuteNameController;
    private long valuteNominalController;
    private double secondValueValuteController;
    private String secondNameValuteController;
    private long secondNominalValuteController;

    public void conversionCurrency() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the currency to convert: ");

        firstValue = reader.readLine(); // ввод данных. получаем данные 1 валюты (вид валюты) от пользователя
        setCurrency(firstValue);//устанавливаем вид валюты для конвертации
        parser();
        valueController = (double) getValuteValue();//значение валюты
        valuteNameController = (String) getValuteName();//название валюты
        valuteNominalController = (long) getValuteNominal();//номинал валюты
        System.out.println("Nominal : " + valuteNominalController + " " + valuteNameController);
        System.out.println(valueController + " " + " rub.");

        secondValue = reader.readLine(); // получаем данные 2 валюты (вид валюты) от пользователя
        setCurrency(secondValue);//устанавливаем вид валюты для конвертации
        parser();
        secondValueValuteController = (double) getValuteValue();
        secondNameValuteController = (String) getValuteName();
        secondNominalValuteController = (long) getValuteNominal();
        System.out.println("Nominal : " + secondNominalValuteController + " " + secondNameValuteController);
        System.out.println(secondValueValuteController + " " + " rub.");

        //вычисляем значние курса по отношению одной валюты к другой
        //1. если наминалы обеих валют равны 1
        if (valuteNominalController == 1 && secondNominalValuteController == 1) {
            double resultNominal = valueController / secondValueValuteController;
            System.out.println("In one " + valuteNameController + " " + resultFormat(resultNominal) + " " + secondNameValuteController);
            System.out.println("end");

            //2. если наминал обеих валют > 1, приводим к значению 1
        } else if (valuteNominalController > 1 && secondNominalValuteController > 1) {
            double resultNominal = (valueController / valuteNominalController) / (secondValueValuteController / secondNominalValuteController);
            System.out.println("In one " + valuteNameController + " " + resultFormat(resultNominal) + " " + secondNameValuteController);
            System.out.println("end");

            //3. если номинал 1 валюты больше 1
        } else if (valuteNominalController > 1 && secondNominalValuteController == 1) {
            double resultNominal = (valueController / valuteNominalController) / secondValueValuteController;
            System.out.println("In one " + valuteNameController + " " + resultFormat(resultNominal) + " " + secondNameValuteController);
            System.out.println("end");

            //4. если номинал 2 валюты больше 1
        } else if (valuteNominalController == 1 && secondNominalValuteController > 1) {
            double resultNominal = valueController / (secondValueValuteController / secondNominalValuteController);
            System.out.println("In one " + valuteNameController + " " + resultFormat(resultNominal) + " " + secondNameValuteController);
            System.out.println("end");

            //если что то пошло не так))
        } else {
            System.out.println("Something's wrong!");
        }

    }

    //formatted  double resultNominal
    public String resultFormat(double result) {
        String resultFormatted = String.format("%.2f", result);
        return resultFormatted;
    }


    public String getFirstValue() {

        return firstValue;
    }

    public void setFirstValue(String firstValue) {

        this.firstValue = firstValue;
    }

    public double getValueController() {

        return valueController;
    }

    public void setValueController(double valueController) {

        this.valueController = valueController;
    }

    public String getValuteNameController() {

        return valuteNameController;
    }

    public void setValuteNameController(String valuteNameController) {
        this.valuteNameController = valuteNameController;
    }

    public void setValuteNominalController(int valuteNominalController) {
        this.valuteNominalController = valuteNominalController;
    }

    public double getSecondValueValuteController() {

        return secondValueValuteController;
    }

    public void setSecondValueValuteController(double secondValueValuteController) {
        this.secondValueValuteController = secondValueValuteController;
    }

    public String getSecondNameValuteController() {

        return secondNameValuteController;
    }

    public void setSecondNameValuteController(String secondNameValuteController) {
        this.secondNameValuteController = secondNameValuteController;
    }

    public long getSecondNominalValuteController() {

        return secondNominalValuteController;
    }

    public void setSecondNominalValuteController(long secondNominalValuteController) {
        this.secondNominalValuteController = secondNominalValuteController;
    }

    public String getFirsValue() {
        return firstValue;
    }

    public void setFirsValue(String firsValue) {

        this.firstValue = firsValue;
    }

    public String getSecondValue() {

        return secondValue;
    }

    public void setSecondValue(String secondValue) {

        this.secondValue = secondValue;
    }

    public long secondNominalValuteController() {

        return secondNominalValuteController;
    }

    public long getValuteNominalController() {

        return valuteNominalController;
    }
}
