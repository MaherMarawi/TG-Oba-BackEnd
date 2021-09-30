package com.example.ObaProject.response;

import com.example.ObaProject.results.evenementen.Event;
import com.example.ObaProject.results.facet.Facet;
import com.example.ObaProject.results.search.Res;

import java.util.List;

public class ResponseEvents {


    private List<Event> events;
    private Facet facet;

    public ResponseEvents() {

    }

    public ResponseEvents(List<Event> events, Facet facet) {
        this.events = events;
        this.facet = facet;
    }

    public List<Event> getResults() {
        return events;
    }

    public void setResults(List<Res> results) {
        this.events = events;
    }

    public Facet getFacet() {
        return facet;
    }

    public void setFacet(Facet facet) {
        this.facet = facet;
    }
}
