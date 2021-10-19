package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.*;
import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.response.ComprehensiveActivityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class ActivityService {

    @Autowired
    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private static GetRequest request;
    private static ActiviteitConfig activiteitConfig;
    private static MetaConfig metaConfig;

    public ActivityService(ApiConfig apiConfig,
                           QueryArrange queryArrange,
                           MetaConfig metaConfig,
                           ActiviteitConfig activiteitConfig,
                           GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.request = request;
        this.activiteitConfig = activiteitConfig;
        this.metaConfig = metaConfig;
    }
    public ComprehensiveActivityResponse getActivities(int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=table:activiteiten" +
                     apiConfig.getAuthorization() +
                     "&refine=true" +
                     apiConfig.getSort() +
                     "&page=" +
                     page;
        return fetchAllData(url);

    }
    public ComprehensiveActivityResponse searchActivity(String search_value, int page) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=table:activiteiten%20" +
                     query +
                     apiConfig.getAuthorization() +
                     "&refine=true"+
                     "&page=" +
                     page;
        return fetchAllData(url);
    }

    public ActiviteitResponse get20Activities(int page) {
        String url = apiConfig.getUrl() +
                "search/?q=table:activiteiten" +
                apiConfig.getAuthorization() +
                "&refine=true"+
                "&page=" +
                page;
        return sendResponse(url);
    }

    public ActiviteitResponse zoekActivity(String search_value, int page) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=table:activiteiten%20" +
                query +
                apiConfig.getAuthorization() +
                "&page=" +
                page ;
        return sendResponse(url);
    }

    public ComprehensiveActivityResponse getActivitiesInLocation(String wijk_naam, int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=table:activiteiten" +
                     apiConfig.getAuthorization() +
                     "&refine=true" +
                     apiConfig.getSort() +
                     "&branch=OBA%20" +
                     wijk_naam +
                     "&page=" +
                     page;
        return fetchAllData(url);
    }

    public static ComprehensiveActivityResponse fetchAllData(String url) {
        return new ComprehensiveActivityResponse(
                sendResponse(url + "&facet=Activiteiten(c_nextweek)"),
                sendResponse(url + "&facet=Activiteiten(d_thismonth)"),
                sendResponse(url + "&facet=Activiteiten(e_nextmonth)"),
                sendResponse(url + "&facet=Activiteiten(f_next3month)"),
                sendResponse(url + "&facet=Activiteiten(g_thisyear)")
        );
    }

    public static ActiviteitResponse sendResponse(String url) {
        Document doc = request.sendRequest(url);
        ActiviteitResponse response = new ActiviteitResponse();
        response.setActiviteiten(activiteitConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setMeta(metaConfig.resultsToJson(doc.getElementsByTagName("meta")));
        return response;
    }


}
