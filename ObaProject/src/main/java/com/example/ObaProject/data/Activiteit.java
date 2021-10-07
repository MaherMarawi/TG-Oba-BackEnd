package com.example.ObaProject.data;

public class Activiteit extends Result {

    private String doelgroep;
    private String begin;
    private String einde;
    private String jaar;



    public Activiteit() {
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
    public String getJaar() {
        return jaar;
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
    public void setJaar(String jaar) {
        this.jaar = jaar;
    }



}
