package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.currencyconverter.dao.ValuteDAO;


@Controller
public class DefaultController {
    private final ValuteDAO valuteDAO;

    public DefaultController(ValuteDAO valuteDAO) {
        this.valuteDAO = valuteDAO;
    }

    @GetMapping("/")
    public String homePage() {

        return "index";
    }

    @PostMapping()
    public String convert(@RequestParam(value = "value") double value, @RequestParam(value = "from") String idFrom, @RequestParam(value = "to") String idTo, Model model) throws Exception {
        double toAmount = valuteDAO.conversion(idFrom, value, idTo);
        model.addAttribute("toAmount", toAmount);
        return "redirect:/";
    }
}
