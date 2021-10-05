package com.example.ObaProject.results.cursussen;

import com.example.ObaProject.results.facet.Facet;

import java.util.List;

public class CursusResponse {
    private List<Cursus> cursussen;
    private Facet facet;

    public CursusResponse() {
    }

    public void setCursussen(List<Cursus> cursussen) {
        this.cursussen = cursussen;
    }

    public void setFacet(Facet facet) {
        this.facet = facet;
    }

    public List<Cursus> getCursussen() {
        return cursussen;
    }

    public Facet getFacet() {
        return facet;
    }
}
