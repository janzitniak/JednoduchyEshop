package sk.tmconsulting.jednoduchyeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.tmconsulting.jednoduchyeshop.model.Tricko;

@Controller
public class JednoduchyEshopController {

    @GetMapping("/") // Lomitko reprezentuje hlavnu (korenovu) URL adresu, cize napr. localhost:8080
    public String uvodnaStranka() {
        return "index";
    }

    @GetMapping("/pridaj-novy-zaznam") // GetMapping reprezentuje URL adresu, ktoru vidime v internetovom prehliadaci
    public String pridajNovyZaznam(Model model) { // Pre odovzdanie objektu do Thymeleafu potrebujeme Model
        Tricko trickoObjekt = new Tricko(); // Vytvorili sme objekt Tricko
        model.addAttribute("trickoObjektThymeleaf", trickoObjekt); // A tymto dany objekt odovzdame do Thymeleaf naozaj
        return "pridaj-novy-zaznam";
    }

}
