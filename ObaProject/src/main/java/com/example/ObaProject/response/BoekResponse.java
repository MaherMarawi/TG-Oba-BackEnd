package com.example.ObaProject.response;

import com.example.ObaProject.data.Boek;
import com.example.ObaProject.data.Facet;
import com.example.ObaProject.data.Meta;

import java.util.List;

public class BoekResponse {
    private Meta meta;
    private List<Boek> boeken;


    public BoekResponse() {
    }

    public List<Boek> getBoeken() {
        return boeken;
    }

    public void setBoeken(List<Boek> boeken) {
        this.boeken = boeken;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
