package com.example.ObaProject.data;
import com.example.ObaProject.data.Activiteit;
import com.example.ObaProject.data.Boek;
import com.example.ObaProject.data.Cursus;
import com.example.ObaProject.data.Facet;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.List;

@Configuration
public class Response {

    private List<Boek> boeken;
    private List<Activiteit> activiteiten;
    private List<Cursus> cursussen;
    private Facet facet;


    public Response() {
    }

    public List<Activiteit> getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(List<Activiteit> activiteiten) {
        this.activiteiten = activiteiten;
    }

    public List<Cursus> getCursussen() {
        return cursussen;
    }

    public void setCursussen(List<Cursus> cursussen) {
        this.cursussen = cursussen;
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
