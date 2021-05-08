package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DefaultController {
    @GetMapping("/index")
    public String homePage(String fromAmount, Model model) {
        model.addAttribute("fromAmount", fromAmount);

        return "index";
    }
}
