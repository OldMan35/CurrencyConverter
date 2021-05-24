package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.currencyconverter.dao.ValuteDAO;
import ru.currencyconverter.model.Valute;

import java.util.Arrays;
import java.util.List;


@Controller
public class DefaultController {
    ValuteDAO valuteDAO;

    public DefaultController(ValuteDAO valuteDAO) {
        this.valuteDAO = valuteDAO;
    }

    @GetMapping("/home")
    public String homePage() {

        return "home_page";
    }

    @GetMapping("/conversion_form")
    public String showForm(Model model) {
        Valute valute = new Valute();
        model.addAttribute("valute", valute);
        List<String> valuteName = Arrays.asList("AUD", "EUR", "AZN", "HKD", "DKK", "CAD", "USD");
        model.addAttribute("valuteName", valuteName);
        return "/conversion_form";
    }

    @PostMapping("/conversion_form")
    public String convert(@ModelAttribute("valute") Valute valute) {
        valuteDAO.getVolume(valute);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String resultConvert(Model model) throws Exception {
        model.addAttribute("idFrom", valuteDAO.getIdFrom());
        model.addAttribute("idTo", valuteDAO.getIdTo());
        model.addAttribute("result", valuteDAO.conversion());
        return "result";
    }
}
