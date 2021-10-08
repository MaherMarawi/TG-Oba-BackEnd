package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.*;
import com.example.ObaProject.response.ActiviteitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class ActivityService {

    @Autowired
    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private final FacetConfig facetConfig;
    private final GetRequest request;
    private final ActiviteitConfig activiteitConfig;

    public ActivityService(ApiConfig apiConfig,
                      QueryArrange queryArrange,
                      FacetConfig facetConfig,
                      ActiviteitConfig activiteitConfig,
                      GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.facetConfig = facetConfig;
        this.request = request;
        this.activiteitConfig = activiteitConfig;
    }
    public ActiviteitResponse getActivities() {
        String url = apiConfig.getUrl() +
                "search/?q=table:activiteiten" +
                apiConfig.getAuthorization() +
                "&refine=true" +
                apiConfig.getSort();
        Document doc = request.sendRequest(url);
        ActiviteitResponse response = new ActiviteitResponse();
        response.setActiviteiten(activiteitConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;

    }
    public ActiviteitResponse searchActivity(String search_value) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=table:activiteiten%20" +
                query +
                apiConfig.getAuthorization() +
                "&refine=true";
        Document doc = request.sendRequest(url);
        ActiviteitResponse response = new ActiviteitResponse();
        response.setActiviteiten(activiteitConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
        return response;
    }

        public ActiviteitResponse getActivitiesInLocation(String wijk_naam) {
        String url = apiConfig.getUrl() +
                "search/?q=table:activiteiten" +
                apiConfig.getAuthorization() +
                "&refine=true" +
                apiConfig.getSort() +
                "&branch=OBA%20" +
                wijk_naam;
            System.out.println(url);
        Document doc = request.sendRequest(url);
            ActiviteitResponse response = new ActiviteitResponse();
            response.setActiviteiten(activiteitConfig.resultsToJson(doc.getElementsByTagName("result")));
            response.setFacet(facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
            return response;
    }

}
