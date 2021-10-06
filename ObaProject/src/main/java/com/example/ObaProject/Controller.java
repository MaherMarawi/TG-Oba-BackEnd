package com.example.ObaProject;

import com.example.ObaProject.api.ApiService;
import com.example.ObaProject.results.activiteiten.ActiviteitResponse;
import com.example.ObaProject.results.boeken.Boek;
import com.example.ObaProject.results.boeken.BoekResponse;
import com.example.ObaProject.results.cursussen.CursusResponse;
import com.example.ObaProject.results.test.Samen;
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

//    @GetMapping("/search/{search_value}")
//    public Response search(@PathVariable String search_value) {
//        return service.search(search_value);
//    }

    // CATEGORIEEN en BOEKEN

    @GetMapping("/boeken/{search_value}")
    public BoekResponse boekenSearch(@PathVariable String search_value) {
        return service.boekenSearch(search_value);
    }

    @GetMapping("/boeken/categorieen")
    public List<String> boekenCategorieen() {
        return service.boekenCategorieen();
    }

    @GetMapping("/boeken/categorieen/{categorie_naam}")
    public List<Boek> boekenCategorie(@PathVariable String categorie_naam) {
        return service.boekenCategorie(categorie_naam);
    }

    @GetMapping("/boeken/categorieen/{categorie_naam}/{search_value}")
    public List<Boek> boekenCategorieSearch(@PathVariable String categorie_naam, @PathVariable String search_value) {
        return service.boekenCategorieSearch(categorie_naam, search_value);
    }

    // ACTIVITEITEN

    @GetMapping("/activiteiten")
    public ActiviteitResponse activiteiten() {
        return service.activiteiten();
    }

    @GetMapping("/activiteiten/{search_value}")
    public ActiviteitResponse activiteitenSearch(@PathVariable String search_value) {
        return service.activiteitenSearch(search_value);
    }
//    @GetMapping("/activiteiten/{wijk_naam}")
//    public Response activiteitenSearch(@PathVariable String wijk_naam) {
//        return service.activiteitenSearch(wijk_naam);
//    }

    // CURSUSSEN

    @GetMapping("/cursussen")
    public CursusResponse cursussen() {
        return service.cursussen();
    }

    @GetMapping("/cursussen/{search_value}")
    public CursusResponse cursussenSearch(@PathVariable String search_value) {
        return service.cursussenSearch(search_value);
    }






    @GetMapping("/alles")
    public Samen activiteit_cusus() {
        return service.activiteit_cusus();
    }

}
