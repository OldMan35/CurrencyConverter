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

    private final ValuteDAO valuteDAO;
    private Valute valute;


    public DefaultController(ValuteDAO valuteDAO) {
        this.valuteDAO = valuteDAO;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

//    @PostMapping()
//    public String convert(@RequestParam("value") double value, @RequestParam("idFrom") String idFrom, @RequestParam("idTo") String idTo, Model model) throws Exception {
//        valute.setIdFrom(idFrom);
//        valute.setIdTo(idTo);
//        valute.setValue(value);
//        double toAmount = valuteDAO.conversion();
//        model.addAttribute("toAmount", toAmount);
//        return "redirect:/index";
//    }
}
