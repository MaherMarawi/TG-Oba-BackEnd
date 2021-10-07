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
    private final FacetConfig facetConfig;
    private final GetRequest request;
    private final BoekConfig boekConfig;

    @Autowired
    public BookService(ApiConfig apiConfig,
                       QueryArrange queryArrange,
                       FacetConfig facetConfig,
                       BoekConfig boekConfig,
                       GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.facetConfig = facetConfig;
        this.request = request;
        this.boekConfig = boekConfig;
    }

    public BoekResponse getBooks(String key) {
        String url = apiConfig.getUrl() +
                "search/?q=special:all" +
                apiConfig.getAuthorization() +
                key ;
        Document doc = request.sendRequest(url);
        BoekResponse response = new BoekResponse();
        response.setBoeken(boekConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }


    public BoekResponse searchBook(String search_value, String key) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=" +
                query +
                apiConfig.getAuthorization() +
                key ;
        Document doc = request.sendRequest(url);
        BoekResponse response = new BoekResponse();
        response.setBoeken(boekConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

    public BoekResponse getLargetypeBooks() {
        String key = "&refine=true&facet=type(largetype)";
        return getBooks(key);
    }
    public BoekResponse searchLargetypeBook(String search_value) {
        String key = "&refine=true&facet=type(largetype)";
        return searchBook(search_value, key);
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

    public List<Boek> getCategory(String categorie_naam) {
        String url = apiConfig.getUrl() +
                "search/?q=classification:" +
                categorie_naam +
                apiConfig.getAuthorization();
        Document doc = request.sendRequest(url);
        return boekConfig.resultsToJson(doc.getElementsByTagName("result"));
    }

    public List<Boek> SearchInsideCategory(String categorie_naam, String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=classification:" +
                categorie_naam +
                "%20" +
                query +
                apiConfig.getAuthorization();
        Document doc = request.sendRequest(url);
        return boekConfig.resultsToJson(doc.getElementsByTagName("result"));
    }


}


