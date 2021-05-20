package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.currencyconverter.dao.ValuteDAO;
import ru.currencyconverter.model.Valute;


@Controller
public class DefaultController {

    private final ValuteDAO valuteDAO;
    private Valute valute;


    public DefaultController(ValuteDAO valuteDAO) {
        this.valuteDAO = valuteDAO;
    }

    @GetMapping("/")
    public String homePage() {

        return "index";
    }

    @PostMapping("/")
    public String convert() {

        return "redirect:/";
    }
}
