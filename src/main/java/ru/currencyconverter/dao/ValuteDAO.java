package ru.currencyconverter.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import ru.currencyconverter.model.Valute;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

@Component
public class ValuteDAO {

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


    public void conversion(String idFrom, int value, String idTo) throws Exception {
        HashMap<String, String> rates = parser();
        int oneNumber = Integer.parseInt(rates.get(idFrom));//get first valute rates from hashmap
        int twoNumber = Integer.parseInt(rates.get(idTo));//get two valute rates from hashmap
        int result = 1 / oneNumber * twoNumber;
        Valute valute = new Valute(result);//set model view
    }
}