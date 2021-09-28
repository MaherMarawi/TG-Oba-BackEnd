package com.example.ObaProject;

import com.example.ObaProject.api.ApiService;
import com.example.ObaProject.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/oba/techgrounds")
public class Controller {

    @Autowired
    ApiService service;

    @GetMapping("/")
    public String home() {
        return "This application has no explicit mapping for /, so you are seeing this as a WelkomstBericht";
    }

    @GetMapping("/search/{search_value}")
    public Response search(@PathVariable String search_value) {
        return service.search(search_value);
    }

    @GetMapping("/categorieen")
    public List<String> categorieen() {
        return service.categorieen();
    }

    @GetMapping("/categorieen/{categorie_naam}")
    public Response categorie(@PathVariable String categorie_naam) {
        return service.categorie(categorie_naam);
    }

    @GetMapping("/categorieen/{categorie_naam}/{search_value}")
    public Response categorieSearch(@PathVariable String categorie_naam, @PathVariable String search_value) {
        return service.categorieSearch(categorie_naam, search_value);
    }
    // NOG NIET GEDAAN
    @GetMapping("/activiteiten")
    public Response activiteit() {
        return service.activiteit();
    }

    @GetMapping("/activiteiten/{wijk_naam}")
    public Response activiteitSearch(@PathVariable String wijk_naam) {
        return service.activiteitSearch(wijk_naam);
    }
}
