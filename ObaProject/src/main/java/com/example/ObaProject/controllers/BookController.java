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
    public BoekResponse getBooks() {
        return bookService.getBooks("&refine=true", 1);
    }

    @GetMapping("/page/{page}")
    public BoekResponse getBooks(@PathVariable int page) {
        return bookService.getBooks("&refine=true", page);
    }

    @GetMapping("/{search_value}")
    public BoekResponse searchBook(@PathVariable String search_value) {
        return bookService.searchBook(search_value, 1, "&refine=true");
    }

    @GetMapping("/{search_value}/page/{page}")
    public BoekResponse searchBook(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchBook(search_value, page, "&refine=true");
    }

    @GetMapping("/largetype")
    public BoekResponse getLargetypeBooks() {
        return bookService.getLargetypeBooks(1);
    }

    @GetMapping("/largetype/page/{page}")
    public BoekResponse getLargetypeBooks(@PathVariable int page) {
        return bookService.getLargetypeBooks(page);
    }

    @GetMapping("/largetype/{search_value}")
    public BoekResponse searchLargetypeBook(@PathVariable String search_value) {
        return bookService.searchLargetypeBook(search_value, 1);
    }

    @GetMapping("/largetype/{search_value}/page/{page}")
    public BoekResponse searchLargetypeBook(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchLargetypeBook(search_value, page);
    }

    @GetMapping("/categorieen")
    public List<String> getBooksCategories() {
        return bookService.getBooksCategories();
    }

    @GetMapping("/categorieen/{categorie_naam}")
    public BoekResponse getCategory(@PathVariable String categorie_naam) {
        return bookService.getCategory(categorie_naam, 1);
    }

    @GetMapping("/categorieen/{categorie_naam}/page/{page}")
    public BoekResponse getCategory(@PathVariable String categorie_naam, @PathVariable int page) {
        return bookService.getCategory(categorie_naam, page);
    }

    @GetMapping("/categorieen/{categorie_naam}/{search_value}")
    public BoekResponse SearchInsideCategory(@PathVariable String categorie_naam, @PathVariable String search_value) {
        return bookService.SearchInsideCategory(categorie_naam, search_value, 1);
    }

    @GetMapping("/categorieen/{categorie_naam}/{search_value}/page/{page}")
    public BoekResponse SearchInsideCategory(@PathVariable String categorie_naam, @PathVariable String search_value, @PathVariable int page) {
        return bookService.SearchInsideCategory(categorie_naam, search_value, page);
    }
}
