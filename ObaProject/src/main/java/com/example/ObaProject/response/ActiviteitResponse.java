package com.example.ObaProject.response;

import com.example.ObaProject.data.Activiteit;
import com.example.ObaProject.data.Facet;

import java.util.List;

public class ActiviteitResponse {

    private List<Activiteit> activiteiten;
    private Facet facet;

    public ActiviteitResponse() {
    }

    public List<Activiteit> getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(List<Activiteit> activiteiten) {
        this.activiteiten = activiteiten;
    }

    public Facet getFacet() {
        return facet;
    }

    public void setFacet(Facet facet) {
        this.facet = facet;
    }
}
