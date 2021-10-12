package com.example.ObaProject.response;

import com.example.ObaProject.data.Activiteit;
import com.example.ObaProject.data.Facet;
import com.example.ObaProject.data.Meta;

import java.util.List;

public class ActiviteitResponse {

    private Meta meta;
    private List<Activiteit> activiteiten;

    public ActiviteitResponse() {
    }

    public List<Activiteit> getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(List<Activiteit> activiteiten) {
        this.activiteiten = activiteiten;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
