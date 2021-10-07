package com.example.ObaProject.controllers;

import com.example.ObaProject.data.Boek;
import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/oba/techgrounds/boeken")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String main(@PathVariable String search_value) {
        return "hello";
    }

    @GetMapping("/{search_value}")
    public BoekResponse searchBook(@PathVariable String search_value) {
        return bookService.searchBook(search_value);
    }

    @GetMapping("/categorieen")
    public List<String> getBooksCategories() {
        return bookService.getBooksCategories();
    }

    @GetMapping("/categorieen/{categorie_naam}")
    public List<Boek> getCategory(@PathVariable String categorie_naam) {
        return bookService.getCategory(categorie_naam);
    }

    @GetMapping("/categorieen/{categorie_naam}/{search_value}")
    public List<Boek> SearchInsideCategory(@PathVariable String categorie_naam, @PathVariable String search_value) {
        return bookService.SearchInsideCategory(categorie_naam, search_value);
    }
}
