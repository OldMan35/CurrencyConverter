package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DefaultController {

    @GetMapping("/index")
    public String string() {

        return "index";
    }
}
