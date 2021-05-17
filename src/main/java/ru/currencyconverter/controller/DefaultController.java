package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.currencyconverter.dao.ValuteDAO;
import ru.currencyconverter.model.Valute;


@Controller
public class DefaultController {

    @GetMapping("/")
    public String homePage() {

        return "index";
    }

    @PostMapping()
    public String convert(@RequestParam("fromAmount") int value, @RequestParam("from") String idFrom, @RequestParam("to") String idTo, Model model) throws Exception {
        ValuteDAO valute = new ValuteDAO();
        valute.conversion(idFrom, value, idTo);
        Valute val = new Valute();
        int toAmount = val.getValue();
        model.addAttribute("toAmount", toAmount);
        return "redirect:/";
    }
}
