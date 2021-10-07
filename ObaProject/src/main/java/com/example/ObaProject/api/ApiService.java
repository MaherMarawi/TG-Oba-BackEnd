package com.example.ObaProject.api;

import com.example.ObaProject.configuration.ApiConfig;
import com.example.ObaProject.configuration.ResultConfig;
import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.data.Boek;
import com.example.ObaProject.configuration.BoekConfig;
import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.configuration.CursusConfig;
import com.example.ObaProject.configuration.ActiviteitConfig;
import com.example.ObaProject.response.CursusResponse;
import com.example.ObaProject.configuration.FacetConfig;
import com.example.ObaProject.data.Samen;
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








//    public Samen activiteit_cusus() {
//        Samen samen = new Samen();
//        samen.setActiviteiten(getActivities());
//        samen.setCursussen(getCourses());
//        return samen;
//    }


//        private static Response response(String url) {
//            Document doc = request.sendRequest(url);
//            return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
//                    facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
//    }
}
