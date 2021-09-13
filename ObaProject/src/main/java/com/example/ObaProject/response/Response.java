package com.example.ObaProject.response;

import com.example.ObaProject.response.facet.Facet;
import com.example.ObaProject.response.result.Res;

import java.util.List;

public class Response {

    private List<Res> results;
    private Facet facet;

    public Response(List<Res> results, Facet facet) {
        this.results = results;
        this.facet = facet;
    }

    public List<Res> getResults() {
        return results;
    }

    public void setResults(List<Res> results) {
        this.results = results;
    }

    public Facet getFacet() {
        return facet;
    }

    public void setFacet(Facet facet) {
        this.facet = facet;
    }
}
