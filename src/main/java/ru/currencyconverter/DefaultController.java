package ru.currencyconverter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

@RestController
public class DefaultController {
    private String currency = "AUD";
    private final String name = "Name";
    private final String value = "Value";
    private final String valute = "Valute";
    private final String nominal = "Nominal";
    private Object valuteNominal;
    private Object valuteName;
    private Object valuteValue;

    
    @RequestMapping("/volute")
    public Object parser() throws Exception {

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
        return valuteName + " " + valuteValue;
    }

    @RequestMapping("/index")
    public String index() {

        return (new Date().toString());
    }
}
