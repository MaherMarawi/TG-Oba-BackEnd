package com.example.ObaProject.controllers;

import com.example.ObaProject.api.ApiService;
import com.example.ObaProject.data.Samen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/oba/techgrounds")
public class Controller {

    @Autowired
    ApiService service;

    @GetMapping("/")
    public String home() {
        return "This application has no explicit mapping for /, so you are seeing this as a WelkomstBericht";
    }

     //SEARCH
//
//    @GetMapping("/search/{search_value}")
//    public Response search(@PathVariable String search_value) {
//        return service.search(search_value);
//    }

//
    @GetMapping("/alles")
    public Samen activiteit_cusus() {
        return service.activiteit_cusus();
    }
}
