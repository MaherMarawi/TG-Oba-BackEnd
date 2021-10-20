package com.example.ObaProject.controllers;

import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.response.ComprehensiveBookResponse;
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
    public ComprehensiveBookResponse getBooks() {
        return bookService.getBooks("&refine=true", 1);
    }

    @GetMapping("/page/{page}")
    public ComprehensiveBookResponse getBooks(@PathVariable int page) {
        return bookService.getBooks("&refine=true", page);
    }

    @GetMapping("/random")
    public BoekResponse getRandomBooks() {
        return bookService.getRandomBooks(1);
    }

    @GetMapping("random/page/{page}")
    public BoekResponse getRandomBooks(@PathVariable int page) {
        return bookService.getRandomBooks(page);
    }

    @GetMapping("/{search_value}")
    public ComprehensiveBookResponse searchBook(@PathVariable String search_value) {
        return bookService.searchBook(search_value, 1, "&refine=true");
    }

    @GetMapping("/{search_value}/page/{page}")
    public ComprehensiveBookResponse searchBook(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchBook(search_value, page, "&refine=true");
    }

    @GetMapping("/zoek/{search_value}")
    public BoekResponse zoekBook(@PathVariable String search_value) {
        return bookService.zoekBook(search_value, 1, "&refine=true&facet=type(book)");
    }

    @GetMapping("/zoek/{search_value}/page/{page}")
    public BoekResponse zoekBook(@PathVariable String search_value, @PathVariable int page) {
        return bookService.zoekBook(search_value, page, "&refine=true&facet=type(book)");
    }

    // LARGETYPE BOOKS

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

    // E_BOOKS

    @GetMapping("/ebook")
    public BoekResponse getEBooks() {
        return bookService.getEBooks(1);
    }

    @GetMapping("/ebook/page/{page}")
    public BoekResponse getEBooks(@PathVariable int page) {
        return bookService.getEBooks(page);
    }

    @GetMapping("/ebook/{search_value}")
    public BoekResponse searchEBook(@PathVariable String search_value) {
        return bookService.searchEBook(search_value, 1);
    }

    @GetMapping("/ebook/{search_value}/page/{page}")
    public BoekResponse searchEBook(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchEBook(search_value, page);
    }

    // AUDIO_BOOKS

    @GetMapping("/audiobook")
    public BoekResponse getAudioBooks() {
        return bookService.getAudioBooks(1);
    }

    @GetMapping("/audiobook/page/{page}")
    public BoekResponse getAudioBooks(@PathVariable int page) {
        return bookService.getAudioBooks(page);
    }

    @GetMapping("/audiobook/{search_value}")
    public BoekResponse searchAudioBooks(@PathVariable String search_value) {
        return bookService.searchAudioBooks(search_value, 1);
    }

    @GetMapping("/audiobook/{search_value}/page/{page}")
    public BoekResponse searchAudioBooks(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchAudioBooks(search_value, page);
    }

    // MOVIES

    @GetMapping("/dvdvideo")
    public BoekResponse getMovies() {
        return bookService.getDvdvideo(1);
    }

    @GetMapping("/dvdvideo/page/{page}")
    public BoekResponse getMovies(@PathVariable int page) {
        return bookService.getDvdvideo(page);
    }

    @GetMapping("/dvdvideo/{search_value}")
    public BoekResponse searchMovies(@PathVariable String search_value) {
        return bookService.searchDvdvideo(search_value, 1);
    }

    @GetMapping("/dvdvideo/{search_value}/page/{page}")
    public BoekResponse searchMovies(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchDvdvideo(search_value, page);
    }

    // NORMAL_BOOKS

    @GetMapping("/book")
    public BoekResponse getNormalBooks() {
        return bookService.getNormalBooks(1);
    }

    @GetMapping("/book/page/{page}")
    public BoekResponse getNormalBooks(@PathVariable int page) {
        return bookService.getNormalBooks(page);
    }

    @GetMapping("/book/{search_value}")
    public BoekResponse searchNormalBooks(@PathVariable String search_value) {
        return bookService.searchNormalBooks(search_value, 1);
    }

    @GetMapping("/book/{search_value}/page/{page}")
    public BoekResponse searchNormalBooks(@PathVariable String search_value, @PathVariable int page) {
        return bookService.searchNormalBooks(search_value, page);
    }

    // CATEGORIEEN

    @GetMapping("/categorieen")
    public List<String> getBooksCategories() {
        return bookService.getBooksCategories();
    }

    @GetMapping("/categorieen/{categorie_naam}")
    public ComprehensiveBookResponse getCategory(@PathVariable String categorie_naam) {
        return bookService.getCategory(categorie_naam, 1);
    }

    @GetMapping("/categorieen/{categorie_naam}/page/{page}")
    public ComprehensiveBookResponse getCategory(@PathVariable String categorie_naam, @PathVariable int page) {
        return bookService.getCategory(categorie_naam, page);
    }

    @GetMapping("/categorieen/{categorie_naam}/{search_value}")
    public ComprehensiveBookResponse SearchInsideCategory(@PathVariable String categorie_naam, @PathVariable String search_value) {
        return bookService.SearchInsideCategory(categorie_naam, search_value, 1);
    }

    @GetMapping("/categorieen/{categorie_naam}/{search_value}/page/{page}")
    public ComprehensiveBookResponse SearchInsideCategory(@PathVariable String categorie_naam, @PathVariable String search_value, @PathVariable int page) {
        return bookService.SearchInsideCategory(categorie_naam, search_value, page);
    }
}
