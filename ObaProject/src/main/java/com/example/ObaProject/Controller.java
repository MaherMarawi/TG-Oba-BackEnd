package com.example.ObaProject;

import com.example.ObaProject.api.ApiService;
import com.example.ObaProject.response.Response;
import com.example.ObaProject.response.ResponseEvents;
import com.example.ObaProject.results.cursussen.Cursus;
import com.example.ObaProject.results.evenementen.Event;
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
    // SEARCH
    // boek-Mark

    @GetMapping("/search/{search_value}")
    public Response search(@PathVariable String search_value) {
        return service.search(search_value);
    }

    // CATEGORIEEN

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
    // ACTIVITEITEN

    @GetMapping("/activiteiten")
    public List<Event> activiteiten() {
        return service.activiteiten();
    }

    @GetMapping("/activiteiten/{wijk_naam}")
    public Response activiteitenSearch(@PathVariable String wijk_naam) {
        return service.activiteitenSearch(wijk_naam);
    }
    // CURSUSSEN

    @GetMapping("/cursussen")
    public List<Cursus> cursussen() {
        return service.cursussen();
    }
}
