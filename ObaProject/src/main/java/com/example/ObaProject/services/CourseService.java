package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.*;
import com.example.ObaProject.response.ComprehensiveBookResponse;
import com.example.ObaProject.response.ComprehensiveCursusResponse;
import com.example.ObaProject.response.CursusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class CourseService {

    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private static MetaConfig metaConfig;
    private static GetRequest request;
    private static CursusConfig cursusConfig;

    @Autowired
    public CourseService(ApiConfig apiConfig,
                         QueryArrange queryArrange,
                         MetaConfig metaConfig,
                         CursusConfig cursusConfig,
                         GetRequest request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.request = request;
        this.cursusConfig = cursusConfig;
        this.metaConfig = metaConfig;
    }

    public ComprehensiveCursusResponse getCourses(int page) {
        String url = apiConfig.getUrl() +
                     "search/?q=table:jsonsrc" +
                     apiConfig.getAuthorization() +
                     "&refine=true" +
                     apiConfig.getSort() +
                     "&page=" +
                     page;
        return fetchAllData(url);
    }

    public ComprehensiveCursusResponse searchCourse(String search_value, int page) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                     "search/?q=table:jsonsrc%20" +
                     query +
                     apiConfig.getAuthorization() +
                     "&refine=true" +
                     "&page=" +
                     page;
        return fetchAllData(url);
    }

    public CursusResponse zoekCourse(String search_value, int page) {
        StringBuilder query = queryArrange.getQuery(search_value);
        String url = apiConfig.getUrl() +
                "search/?q=table:jsonsrc%20" +
                query +
                apiConfig.getAuthorization() +
                "&refine=true" +
                "&page=" +
                page;
        return sendResponse(url);
    }
    public static ComprehensiveCursusResponse fetchAllData(String url) {
        return new ComprehensiveCursusResponse(
                sendResponse(url + "&facet=Activiteiten(c_thisweek)"),
                sendResponse(url + "&facet=Activiteiten(d_thismonth)"),
                sendResponse(url + "&facet=Activiteiten(e_nextmonth)"),
                sendResponse(url + "&facet=Activiteiten(f_next3month)"),
                sendResponse(url + "&facet=Activiteiten(g_thisyear)")
        );
    }
    public static CursusResponse sendResponse(String url) {
        Document doc = request.sendRequest(url);
        CursusResponse response = new CursusResponse();
        response.setCursussen(cursusConfig.resultsToJson(doc.getElementsByTagName("result")));
        response.setMeta(metaConfig.resultsToJson(doc.getElementsByTagName("meta")));
        return response;
    }
}
