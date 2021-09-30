package com.example.ObaProject.results.evenementen;

import com.example.ObaProject.results.Result;

public class Event extends Result {

    private String doelgroep;
    private String begin;
    private String einde;

    public Event() {
    }

    public String getDoelgroep() {
        return doelgroep;
    }
    public String getBegin() {
        return begin;
    }
    public String getEinde() {
        return einde;
    }

    public void setDoelgroep(String doelgroep) {
        this.doelgroep = doelgroep;
    }
    public void setBegin(String begin) {
        this.begin = begin;
    }
    public void setEinde(String einde) {
        this.einde = einde;
    }



}
