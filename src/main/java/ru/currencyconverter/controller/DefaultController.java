package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DefaultController {

    @GetMapping("/home_page")
    public String homePage() {
        return "home_page";
    }

    @PostMapping("/conversion_form")
    public String convert() {

        return "/conversion_form";
    }

    @GetMapping("/result")
    public String resultConvert()  {

        return "result";
    }
}
