package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.*;
import com.example.ObaProject.data.Boek;
import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.response.ComprehensiveBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private static GetRequest request;
    private static BoekConfig boekConfig;
    private static MetaConfig metaConfig;

    @Autowired
    public BookService(ApiConfig apiConfig,
                       QueryArrange queryArrange,
                       BoekConfig boekConfig,
                       MetaConfig metaConfig,
                       GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.request = request;
        this.boekConfig = boekConfig;
        this.metaConfig = metaConfig;
    }


    public ComprehensiveBookResponse getBooks(String key, int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=special:all" +
                     apiConfig.getAuthorization() +
                     key +
                     "&page=" +
                     page ;
        return fetchAllData(url);
    }

    public ComprehensiveBookResponse getAllBooks(String link, String str) {
        String url = link + str;
        return fetchAllData(url);
    }


    public ComprehensiveBookResponse searchBook(String search_value, int page, String key) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=" +
                     query +
                     apiConfig.getAuthorization() +
                     key +
                     "&page=" +
                     page ;
        return fetchAllData(url);
    }

    public BoekResponse zoekBook(String search_value, int page, String key) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=" +
                query +
                apiConfig.getAuthorization() +
                key +
                "&page=" +
                page ;
        return sendResponse(url);
    }

    public BoekResponse getRandomBooks(int page) {
        String url = apiConfig.getUrl() +
                "search/?q=special:all" +
                apiConfig.getAuthorization() +
                "&page=" +
                page ;
        return sendResponse(url);
    }

    // LARGETYPE BOOKS

    public BoekResponse getLargetypeBooks(int page) {
        String key = "&refine=true&facet=type(largetype)";
        String url = apiConfig.getUrl() +
                     "search/?q=special:all" +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key ;
        return sendResponse(url);
    }
    public BoekResponse searchLargetypeBook(String search_value, int page) {
        String key = "&refine=true&facet=type(largetype)";
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }

    // E_BOOKS

    public BoekResponse getEBooks(int page) {
        String key = "&refine=true&facet=type(ebook)";
        String url = apiConfig.getUrl() +
                     "search/?q=e-book" +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page;
        BoekResponse ebooks = sendResponse(url);
        List<Boek> books = ebooks.getBoeken().stream().filter(x -> x.getGenre().equals("ebook")).collect(Collectors.toList());
        ebooks.setBoeken(books);
        return ebooks;
    }
    public BoekResponse searchEBook(String search_value, int page) {
        String key = "&refine=true&facet=type(ebook)";
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=e-book%20" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page;
        BoekResponse ebooks = sendResponse(url);
        List<Boek> books = ebooks.getBoeken().stream().filter(x -> x.getGenre().equals("ebook")).collect(Collectors.toList());
        ebooks.setBoeken(books);
        return ebooks;
    }

    // AUDIO_BOOKS

    public BoekResponse getAudioBooks(int page) {
        String key = "&refine=true&facet=type(audiobook)";
        String url = apiConfig.getUrl() +
                     "search/?q=special:all" +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }
    public BoekResponse searchAudioBooks(String search_value, int page) {
        String key = "&refine=true&facet=type(audiobook)";
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }

    // MOVIES

    public BoekResponse getDvdvideo(int page) {
        String key = "&refine=true&facet=type(movie)";
        String url = apiConfig.getUrl() +
                     "search/?q=special:all" +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }
    public BoekResponse searchDvdvideo(String search_value, int page) {
        String key = "&refine=true&facet=type(movie)";
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }

    // MOVIES

    public BoekResponse getNormalBooks(int page) {
        String key = "&refine=true&facet=type(book)";
        String url = apiConfig.getUrl() +
                     "search/?q=special:all" +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }
    public BoekResponse searchNormalBooks(String search_value, int page) {
        String key = "&refine=true&facet=type(book)";
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page +
                     key;
        return sendResponse(url);
    }


    public List<String> getBooksCategories() {
        String url = apiConfig.getUrl() +
                     "index/classification/?" +
                     apiConfig.getAuthorization().substring(1, apiConfig.getAuthorization().length());
        Document doc = request.sendRequest(url);
        NodeList results = doc.getElementsByTagName("result");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < results.getLength(); i++) {
            res.add(results.item(i).getTextContent());
        }
        return res;
    }

    public ComprehensiveBookResponse getCategory(String categorie_naam, int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=classification:" +
                     categorie_naam +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page;
        return fetchAllData(url);
    }

    public ComprehensiveBookResponse SearchInsideCategory(String categorie_naam, String search_value, int page) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=classification:" +
                     categorie_naam +
                     "%20" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page;
       return fetchAllData(url);
    }

    public static ComprehensiveBookResponse fetchAllData(String url) {
        return new ComprehensiveBookResponse(
                sendResponse(url + "&facet=type(largetype)"),
                sendResponse(url + "&facet=type(audiobook)"),
                sendResponse(url + "&facet=type(ebook)"),
                sendResponse(url + "&facet=type(book)"),
                sendResponse(url + "&facet=type(movie)")
        );
    }

    public static BoekResponse sendResponse(String url) {
        Document doc = request.sendRequest(url);
        BoekResponse response = new BoekResponse();
        response.setBoeken(boekConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setMeta(metaConfig.resultsToJson(doc.getElementsByTagName("meta")));
        return response;
    }

}


