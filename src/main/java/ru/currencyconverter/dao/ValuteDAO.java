package ru.currencyconverter.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import ru.currencyconverter.model.ParserJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

@Component
public class ValuteDAO extends ParserJson {
    private String firstValue;
    private String secondValue;
    private double valueController;
    private String valuteNameController;
    private long valuteNominalController;
    private double secondValueValuteController;
    private String secondNameValuteController;
    private long secondNominalValuteController;
    private String currency;
    private Object valuteNominal;
    private Object valuteName;
    private Object valuteValue;


    public HashMap<String, String> parser() throws Exception {

        URL url = new URL("https://www.cbr-xml-daily.ru/latest.js");//Создает объект URL с путем к странице
        InputStream input = url.openStream();//Получает InputStream у интернет-объекта
        byte[] buffer = input.readAllBytes();//Читает все байты и возвращает массив байт
        String strings = new String(buffer);//Преобразуем массив в строку
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(strings);// парсим строку
        JSONObject jsonObject = (JSONObject) obj;//получаем объект JSON
        JSONObject jsonObjectContent = (JSONObject) jsonObject.get("rates");
        String stringObjectContent = jsonObjectContent.toString();
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> rates = mapper.readValue(stringObjectContent, new TypeReference<>() {
        });
        return rates;
    }


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
}
