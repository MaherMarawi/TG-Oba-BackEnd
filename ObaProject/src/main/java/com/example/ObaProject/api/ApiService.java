package com.example.ObaProject.api;

import com.example.ObaProject.response.facet.FacetConfig;
import com.example.ObaProject.response.Response;
import com.example.ObaProject.response.result.ResConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ApiService {

    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private final ResConfig resConfig;
    private final FacetConfig facetConfig;
    private final GetRequest request;

    @Autowired
    public ApiService(ApiConfig apiConfig,
                      QueryArrange queryArrange,
                      ResConfig resConfig,
                      FacetConfig facetConfig,
                      GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.resConfig = resConfig;
        this.facetConfig = facetConfig;
        this.request = request;
    }

    public Response search(String search_value) {

//        String extra = "&facet=language(eng)&facet=type(dvdvideo)";
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     query +
                     "&authorization=" +
                     apiConfig.getPublicKey() +
                     "&refine=true";
        Document doc = request.sendRequest(url);
        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                            facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }

    public List<String> categorieen() {
        String url = apiConfig.getCategorieen() +
                "authorization=" +
                apiConfig.getPublicKey();
        Document doc = request.sendRequest(url);
        NodeList results = doc.getElementsByTagName("result");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < results.getLength(); i++) {
            res.add(results.item(i).getTextContent());
        }
        return res;
    }

    public Response categorie(String categorie_naam) {
        String url = apiConfig.getUrl() +
                    "classification:" +
                    categorie_naam +
                    "&authorization=" +
                    apiConfig.getPublicKey();
        Document doc = request.sendRequest(url);
        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }

    public Response categorieSearch(String categorie_naam, String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                    "classification:" +
                    categorie_naam +
                    "%20" +
                    query +
                    "&authorization=" +
                    apiConfig.getPublicKey();
        Document doc = request.sendRequest(url);
        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }

    public Response activiteit() {
        String url = apiConfig.getUrl() +
                    "table:activiteiten" +
                    "&authorization=" +
                    apiConfig.getPublicKey() +
                    "&refine=true" +
                    apiConfig.getSort();
        Document doc = request.sendRequest(url);
        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }

    public Response activiteitSearch(String wijk_naam) {
        String url = apiConfig.getUrl() +
                "table:activiteiten" +
                "&authorization=" +
                apiConfig.getPublicKey() +
                "&refine=true" +
                apiConfig.getSort() +
                "&branch=OBA%20" +
                wijk_naam;
        Document doc = request.sendRequest(url);
        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }

    public Response cursussen() {
        String url = apiConfig.getUrl() +
                "table:jsonsrc" +
                "&authorization=" +
                apiConfig.getPublicKey() +
                "&refine=true" +
                apiConfig.getSort();
        Document doc = request.sendRequest(url);
        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }
//        private static Response response(String url) {
//            Document doc = request.sendRequest(url);
//            return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
//                    facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
//    }
}
