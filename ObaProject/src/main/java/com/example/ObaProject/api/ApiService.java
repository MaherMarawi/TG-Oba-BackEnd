package com.example.ObaProject.api;

import com.example.ObaProject.results.ResultConfig;
import com.example.ObaProject.results.activiteiten.ActiviteitResponse;
import com.example.ObaProject.results.boeken.Boek;
import com.example.ObaProject.results.boeken.BoekConfig;
import com.example.ObaProject.results.boeken.BoekResponse;
import com.example.ObaProject.results.cursussen.Cursus;
import com.example.ObaProject.results.cursussen.CursusConfig;
import com.example.ObaProject.results.activiteiten.Activiteit;
import com.example.ObaProject.results.activiteiten.ActiviteitConfig;
import com.example.ObaProject.results.cursussen.CursusResponse;
import com.example.ObaProject.results.facet.FacetConfig;
import com.example.ObaProject.response.Response;
import com.example.ObaProject.results.test.Samen;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ApiService {

    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
//    private final SearchConfig resConfig;
    private final FacetConfig facetConfig;
    private final GetRequest request;
    private final ActiviteitConfig activiteitConfig;
    private final CursusConfig cursusConfig;
    private final BoekConfig boekConfig;
    private final ResultConfig resultConfig;

    @Autowired
    public ApiService(ApiConfig apiConfig,
                      QueryArrange queryArrange,
                      FacetConfig facetConfig,
                      ActiviteitConfig activiteitConfig,
                      CursusConfig cursusConfig,
                      BoekConfig boekConfig,
                      ResultConfig resultConfig,
                      GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
//        this.resConfig = resConfig;
        this.facetConfig = facetConfig;
        this.request = request;
        this.activiteitConfig = activiteitConfig;
        this.cursusConfig = cursusConfig;
        this.boekConfig = boekConfig;
        this.resultConfig = resultConfig;
    }

//    public Response search(String search_value) {
//
//        StringBuilder query = queryArrange.getQuery(search_value);
//        String url = apiConfig.getUrl() +
//                     query +
//                     apiConfig.getAuthorization() +
//                     "&refine=true";
//        System.out.println(url);
//        Document doc = request.sendRequest(url);
//        Response search = resultConfig.resultsToJson(doc.getElementsByTagName("result"));
//        return search;
//    }

    public BoekResponse boekenSearch(String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                    query +
                    apiConfig.getAuthorization() +
                    "&refine=true";
        Document doc = request.sendRequest(url);
        BoekResponse response = new BoekResponse();
        response.setBoeken(boekConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

    public List<String> boekenCategorieen() {
        String url = apiConfig.getCategorieen() +
                     apiConfig.getAuthorization();
        Document doc = request.sendRequest(url);
        NodeList results = doc.getElementsByTagName("result");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < results.getLength(); i++) {
            res.add(results.item(i).getTextContent());
        }
        return res;
    }

    public List<Boek> boekenCategorie(String categorie_naam) {
        String url = apiConfig.getUrl() +
                    "classification:" +
                    categorie_naam +
                    apiConfig.getAuthorization();
        Document doc = request.sendRequest(url);
        return boekConfig.resultsToJson(doc.getElementsByTagName("result"));
    }

    public List<Boek> boekenCategorieSearch(String categorie_naam, String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                    "classification:" +
                    categorie_naam +
                    "%20" +
                    query +
                    apiConfig.getAuthorization();
        Document doc = request.sendRequest(url);
        return boekConfig.resultsToJson(doc.getElementsByTagName("result"));
    }

    public ActiviteitResponse activiteiten() {
        String url = apiConfig.getUrl() +
                    "table:activiteiten" +
                    apiConfig.getAuthorization() +
                    "&refine=true" +
                    apiConfig.getSort();
        Document doc = request.sendRequest(url);
        ActiviteitResponse response = new ActiviteitResponse();
        response.setActiviteiten(activiteitConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;

    }
    public ActiviteitResponse activiteitenSearch(String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "table:activiteiten%20" +
                query +
                apiConfig.getAuthorization() +
                "&refine=true";
        System.out.println(url);
        Document doc = request.sendRequest(url);
        ActiviteitResponse response = new ActiviteitResponse();
        response.setActiviteiten(activiteitConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

//    public Response activiteitenSearch(String wijk_naam) {
//        String url = apiConfig.getUrl() +
//                "table:activiteiten" +
//                apiConfig.getAuthorization() +
//                "&refine=true" +
//                apiConfig.getSort() +
//                "&branch=OBA%20" +
//                wijk_naam;
//        Document doc = request.sendRequest(url);
//        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
//                facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
//    }

    public CursusResponse cursussen() {
        String url = apiConfig.getUrl() +
                "table:jsonsrc" +
                apiConfig.getAuthorization() +
                "&refine=true" +
                apiConfig.getSort();
        Document doc = request.sendRequest(url);
        CursusResponse response = new CursusResponse();
        response.setCursussen(cursusConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

    public CursusResponse cursussenSearch(String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "table:jsonsrc%20" +
                query +
                apiConfig.getAuthorization() +
                "&refine=true";
        Document doc = request.sendRequest(url);
        CursusResponse response = new CursusResponse();
        response.setCursussen(cursusConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

    public Samen activiteit_cusus() {
        Samen samen = new Samen();
        samen.setActiviteiten(activiteiten());
        samen.setCursussen(cursussen());
        return samen;
    }


//        private static Response response(String url) {
//            Document doc = request.sendRequest(url);
//            return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
//                    facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
//    }
}
