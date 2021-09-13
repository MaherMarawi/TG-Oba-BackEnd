package com.example.ObaProject.api;

import com.example.ObaProject.response.facet.FacetConfig;
import com.example.ObaProject.response.Response;
import com.example.ObaProject.response.result.ResConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.*;

@org.springframework.stereotype.Service
public class ApiService {

    private final ApiConfig apiConfig;
    private final QueryArrange queryArrange;
    private final ResConfig resConfig;
    private final FacetConfig facetConfig;
    private final Request request;

    @Autowired
    public ApiService(ApiConfig apiConfig,
                      QueryArrange queryArrange,
                      ResConfig resConfig,
                      FacetConfig facetConfig,
                      Request request) {
        this.apiConfig = apiConfig;
        this.queryArrange = queryArrange;
        this.resConfig = resConfig;
        this.facetConfig = facetConfig;
        this.request = request;
    }

    public Response search(String search_value) {

        String extra = "&facet=language(eng)&facet=type(dvdvideo)";

        StringBuilder query = queryArrange.getQuery(search_value);

        String url = apiConfig.getUrl() +
                        query + "&authorization=" +
                            apiConfig.getPublicKey() +
                                "&refine=true";

        Document doc = request.sendRequest(url);

        return new Response(resConfig.resultsToJson(doc.getElementsByTagName("result")),
                            facetConfig.resultsToJson(doc.getElementsByTagName("facet")));
    }
}
