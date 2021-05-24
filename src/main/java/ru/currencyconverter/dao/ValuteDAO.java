package ru.currencyconverter.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import ru.currencyconverter.model.Valute;

import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;

@Component
public class ValuteDAO {
    private String idFrom;
    private String idTo;
    private double value;

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

    public String conversion() throws Exception {
        HashMap<String, String> rates = parser();
        double oneNumber = Double.parseDouble(rates.get(idFrom));//get first valute rates from hashmap
        double twoNumber = Double.parseDouble(rates.get(idTo));//get two valute rates from hashmap
        double convert = 1 / oneNumber * twoNumber * value;
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = decimalFormat.format(convert);
        return result;
    }

    public void getVolume(Valute valute) {
        idFrom = valute.getSelectFirstCurrency();
        idTo = valute.getSelectSecondCurrency();
        value = valute.getValue();
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
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
}