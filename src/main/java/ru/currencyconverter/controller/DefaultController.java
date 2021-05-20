package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DefaultController {

    @GetMapping("/")
    public String homePage() {
        return "convertion_form";
    }

    @PostMapping("/")
    public String convert() {

        return "/";
    }

    @GetMapping("/result")
    public String resultConvert()  {

        return "result";
    }
}
