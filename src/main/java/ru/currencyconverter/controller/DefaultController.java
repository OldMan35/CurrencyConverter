package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.currencyconverter.model.Valute;


@Controller
public class DefaultController {

    @GetMapping("/home_page")
    public String homePage() {
        return "home_page";
    }

    @GetMapping("/conversion_form")
    public String showForm(Model model) {
        Valute valute = new Valute();
        model.addAttribute("valute", valute);
        return "/conversion_form";
    }

    @PostMapping("/conversion_form")
    @RequestMapping(value = "/conversion_form", method = RequestMethod.POST)
    public String convert(@ModelAttribute("valute") Valute valute) {

        return "/result";
    }

    @GetMapping("/result")
    public String resultConvert() {

        return "result";
    }
}
