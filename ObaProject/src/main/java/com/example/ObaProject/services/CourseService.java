package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.*;
import com.example.ObaProject.response.CursusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class CourseService {

    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private final FacetConfig facetConfig;
    private final GetRequest request;
    private final CursusConfig cursusConfig;

    @Autowired
    public CourseService(ApiConfig apiConfig,
                      QueryArrange queryArrange,
                      FacetConfig facetConfig,
                      CursusConfig cursusConfig,
                      GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.facetConfig = facetConfig;
        this.request = request;
        this.cursusConfig = cursusConfig;
    }

    public CursusResponse getCourses() {
        String url = apiConfig.getUrl() +
                "search/?q=table:jsonsrc" +
                apiConfig.getAuthorization() +
                "&refine=true" +
                apiConfig.getSort();
        Document doc = request.sendRequest(url);
        CursusResponse response = new CursusResponse();
        response.setCursussen(cursusConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

    public CursusResponse searchCourse(String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=table:jsonsrc%20" +
                query +
                apiConfig.getAuthorization() +
                "&refine=true";
        Document doc = request.sendRequest(url);
        CursusResponse response = new CursusResponse();
        response.setCursussen(cursusConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        System.out.println(response.getCursussen().size());
        return response;
    }

}
