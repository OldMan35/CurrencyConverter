package ru.currencyconverter.model;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.net.URL;


public class ParserJson {

    private String currency;
    private final String name = "Name";
    private final String value = "Value";
    private final String valute = "Valute";
    private final String nominal = "Nominal";
    private Object valuteNominal;
    private Object valuteName;
    private Object valuteValue;

    public void parser() throws Exception {

        URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");//Создает объект URL с путем к странице
        InputStream input = url.openStream();//Получает InputStream у интернет-объекта
        byte[] buffer = input.readAllBytes();//Читает все байты и возвращает массив байт
        String strings = new String(buffer);//Преобразуем массив в строку
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(strings);// парсим строку
        JSONObject jsonObject = (JSONObject) obj;//получаем объект JSON
        JSONObject jsonСontent = (JSONObject) jsonObject.get(valute);//разбираем объект по значениям
        JSONObject valuteСontent = (JSONObject) jsonСontent.get(currency);//получаем запрос на вид валюты от пользователя
        valuteNominal = valuteСontent.get(nominal);//получаем номинал валюты
        valuteName = valuteСontent.get(name);//название валюты для вывода пользователю
        valuteValue = valuteСontent.get(value);//значение валюты для расчета значения конвертации
    }

    public void setCurrency(String currency) {

        this.currency = currency;
    }

    public Object getValuteName() {

        return valuteName;
    }

    public Object getValuteValue() {

        return valuteValue;
    }

    public Object getValuteNominal() {

        return valuteNominal;
    }
}
