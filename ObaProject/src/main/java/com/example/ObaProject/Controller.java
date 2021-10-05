package com.example.ObaProject;

import com.example.ObaProject.api.ApiService;
import com.example.ObaProject.results.boeken.Boek;
import com.example.ObaProject.results.cursussen.Cursus;
import com.example.ObaProject.results.activiteiten.Activiteit;
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

    // SEARCH

    @GetMapping("/search/{search_value}")
    public Response search(@PathVariable String search_value) {
        return service.search(search_value);
    }

    @GetMapping("/boeken/{search_value}")
    public List<Boek> boekenSearch(@PathVariable String search_value) {
        return service.boekenSearch(search_value);
    }

    // CATEGORIEEN

    @GetMapping("/boeken/categorieen")
    public List<String> categorieen() {
        return service.categorieen();
    }

    @GetMapping("/boeken/categorieen/{categorie_naam}")
    public List<Boek> categorie(@PathVariable String categorie_naam) {
        return service.categorie(categorie_naam);
    }

    @GetMapping("/boeken/categorieen/{categorie_naam}/{search_value}")
    public List<Boek> categorieSearch(@PathVariable String categorie_naam, @PathVariable String search_value) {
        return service.categorieSearch(categorie_naam, search_value);
    }

    // ACTIVITEITEN

    @GetMapping("/activiteiten")
    public List<Activiteit> activiteiten() {
        return service.activiteiten();
    }

    @GetMapping("/activiteiten/{search_value}")
    public List<Activiteit> activiteitenSearch(@PathVariable String search_value) {
        return service.activiteitenSearch(search_value);
    }
//    @GetMapping("/activiteiten/{wijk_naam}")
//    public Response activiteitenSearch(@PathVariable String wijk_naam) {
//        return service.activiteitenSearch(wijk_naam);
//    }

    // CURSUSSEN

    @GetMapping("/cursussen")
    public List<Cursus> cursussen() {
        return service.cursussen();
    }

    @GetMapping("/cursussen/{search_value}")
    public List<Cursus> cursussenSearch(@PathVariable String search_value) {
        return service.cursussenSearch(search_value);
    }
}
