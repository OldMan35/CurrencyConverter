package ru.currencyconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.currencyconverter.dao.ValuteDAO;
import ru.currencyconverter.model.Valute;


@Controller
public class DefaultController {
    ValuteDAO valuteDAO;

    public DefaultController(ValuteDAO valuteDAO) {
        this.valuteDAO = valuteDAO;
    }

    //done
    @GetMapping("/home")
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
        valuteDAO.getVolume(valute);
        return "redirect:/result";
    }

    //done
    @GetMapping("/result")
    public String resultConvert(Model model) throws Exception {
        model.addAttribute("idFrom", valuteDAO.getIdFrom());
        model.addAttribute("idTo", valuteDAO.getIdTo());
        model.addAttribute("result", valuteDAO.conversion());
        return "result";
    }
}
