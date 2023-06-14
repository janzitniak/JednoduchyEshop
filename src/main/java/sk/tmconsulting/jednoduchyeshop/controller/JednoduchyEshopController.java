package sk.tmconsulting.jednoduchyeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.tmconsulting.jednoduchyeshop.model.Tricko;
import sk.tmconsulting.jednoduchyeshop.service.TrickoService;

@Controller
public class JednoduchyEshopController {

    @Autowired // Dependency Injection
    private TrickoService trickoService; // Akokeby ste vytvorili objekt trickoService, nieco take ako TrickoService trickoService = new TrickoService();

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

    @PostMapping("/uloz-zaznam") // Toto je URI adresa, cize cas webovej adresy na konci
    public String ulozZaznam(@ModelAttribute("trickoObjektThymeleaf") Tricko trickoObjektNaplneny) {
        // Ulozenie trickoObjektNaplneny do MySQL databazy
        trickoService.ulozTricko(trickoObjektNaplneny);
        return "index"; // Presmerujeme sa na hlavnu korenovu stranku
    }

    @GetMapping("/zobraz-vsetky-zaznamy") // Toto je URI adresa, cize cas webovej adresy na konci
    public String zobrazVsetkyZaznamy(Model model) { // Pre odovzdanie objektu do Thymeleafu potrebujeme Model
        model.addAttribute("trickaZoznamThymeleaf", trickoService.ziskajVsetkyTricka()); // A tymto dany objekt odovzdame do Thymeleaf naozaj
        return "zobraz-vsetky-zaznamy";
    }

    @GetMapping("/uprav-zaznam/{id}") // Potrebujeme odchytit nielen URI adresu ale aj ID zaznamu, cize tricka
    public String upravZaznam(@PathVariable(value="id") long id, Model model) {
        Tricko trickoZDatabazy = trickoService.ziskajTrickoPodlaId(id);
        model.addAttribute("trickoZDatabazyThymeleaf", trickoZDatabazy);
        return "uprav-zaznam";
    }

    @PostMapping("/uloz-upraveny-zaznam") // Toto je URI adresa, cize cas webovej adresy na konci
    public String ulozUpravenyZaznam(@ModelAttribute("trickoZDatabazyThymeleaf") Tricko trickoObjektNaplneny) {
        // Ulozenie trickoObjektNaplneny do MySQL databazy
        trickoService.ulozTricko(trickoObjektNaplneny); // Metodu ulozTricko pouzijeme na ulozenie aj upraveneho zaznamu
        return "index"; // Presmerujeme sa na hlavnu korenovu stranku
    }

    @GetMapping("/odstran-zaznam/{id}") // Potrebujeme odchytit nielen URI adresu ale aj ID zaznamu, cize tricka
    public String odstranZaznam(@PathVariable(value="id") long id, Model model) {
        trickoService.odstranTricko(id);
        return "index";
    }


}
