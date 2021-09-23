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

    @GetMapping("/search/{search_value}")
    public Response search(@PathVariable String search_value) {
        return service.search(search_value);
    }

    @GetMapping("/categorieen")
    public List<String> categorieen() {
        return service.categorieen();
    }

    @GetMapping("/categorieen/{categorie_name}")
    public Response categorie(@PathVariable String categorie_name) {
        return service.categorie(categorie_name);
    }

    @GetMapping("/categorieen/{categorie_name}/{search_value}")
    public Response categorieSearch(@PathVariable String categorie_name, @PathVariable String search_value) {
        return service.categorieSearch(categorie_name, search_value);
    }
}
