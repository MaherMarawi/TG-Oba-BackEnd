package com.example.ObaProject.response;

import com.example.ObaProject.data.Cursus;
import com.example.ObaProject.data.Facet;
import com.example.ObaProject.data.Meta;

import java.util.List;

public class CursusResponse {
    private Meta meta;
    private List<Cursus> cursussen;

    public CursusResponse() {
    }

    public void setCursussen(List<Cursus> cursussen) {
        this.cursussen = cursussen;
    }


    public List<Cursus> getCursussen() {
        return cursussen;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
