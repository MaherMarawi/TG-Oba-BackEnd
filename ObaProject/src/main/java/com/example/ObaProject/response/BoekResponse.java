package com.example.ObaProject.response;

import com.example.ObaProject.data.Boek;
import com.example.ObaProject.data.Facet;

import java.util.List;

public class BoekResponse {
    private List<Boek> boeken;
    private Facet facet;

    public BoekResponse() {
    }

    public List<Boek> getBoeken() {
        return boeken;
    }

    public void setBoeken(List<Boek> boeken) {
        this.boeken = boeken;
    }

    public Facet getFacet() {
        return facet;
    }

    public void setFacet(Facet facet) {
        this.facet = facet;
    }
}
