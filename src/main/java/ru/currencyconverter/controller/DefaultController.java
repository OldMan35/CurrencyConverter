package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DefaultController {
    @GetMapping("/")
    public String homePage() {

        return "index";
    }

    @PostMapping()
    public String convert(@RequestParam("fromAmount") String fromAmount, @RequestParam("toAmount") String toAmount) {

        System.out.println(fromAmount + toAmount);
        return "redirect:/";
    }
}
