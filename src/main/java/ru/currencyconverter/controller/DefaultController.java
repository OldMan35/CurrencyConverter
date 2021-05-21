package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.currencyconverter.model.Valute;


@Controller
public class DefaultController {
    //done
    @GetMapping("/home_page")
    public String homePage() {

        return "home_page";
    }
    //done
    @GetMapping("/conversion_form")
    public String showForm(Model model) {
        Valute valute = new Valute();
        model.addAttribute("valute", valute);
        return "/conversion_form";
    }
    //done
    @PostMapping("/conversion_form")
    @RequestMapping(value = "/conversion_form", method = RequestMethod.POST)
    public String convert(@ModelAttribute("valute") Valute valute) {
        System.out.println(valute);
        return "/result";
    }

    //done
    @GetMapping("/result")
    public String resultConvert() {
        return "result";
    }
}
