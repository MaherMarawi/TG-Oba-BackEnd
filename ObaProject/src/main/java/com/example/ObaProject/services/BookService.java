package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.*;
import com.example.ObaProject.data.Boek;
import com.example.ObaProject.response.BoekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

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

    public BoekResponse getBooks(String key, int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=special:all" +
                     apiConfig.getAuthorization() +
                     key +
                     "&page=" +
                     page ;
        return sendResponse(url);
    }


    public BoekResponse searchBook(String search_value, int page, String key) {
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

    public BoekResponse getLargetypeBooks(int page) {
        String key = "&refine=true&facet=type(largetype)";
        return getBooks(key, page);
    }
    public BoekResponse searchLargetypeBook(String search_value, int page) {
        String key = "&refine=true&facet=type(largetype)";
        return searchBook(search_value, page, key);
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

    public BoekResponse getCategory(String categorie_naam, int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=classification:" +
                     categorie_naam +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page;
        return sendResponse(url);
    }

    public BoekResponse SearchInsideCategory(String categorie_naam, String search_value, int page) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=classification:" +
                     categorie_naam +
                     "%20" +
                     query +
                     apiConfig.getAuthorization() +
                     "&page=" +
                     page;
       return sendResponse(url);
    }


    public static BoekResponse sendResponse(String url) {
        Document doc = request.sendRequest(url);
        BoekResponse response = new BoekResponse();
        response.setBoeken(boekConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setMeta(metaConfig.resultsToJson(doc.getElementsByTagName("meta")));
        return response;
    }

}


