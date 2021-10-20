package com.example.ObaProject.data;

public class Activiteit extends Result {

    private String doelgroep;
    private String tijd;
    private String datum;
    private String jaar;



    public Activiteit() {
    }

    public String getDoelgroep() {
        return doelgroep;
    }
    public String getTijd() {
        return tijd;
    }
    public String getDatum() {
        return datum;
    }
    public String getJaar() {
        return jaar;
    }

    public void setDoelgroep(String doelgroep) {
        this.doelgroep = doelgroep;
    }
    public void setTijd(String tijd) {
        this.tijd = tijd;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }
    public void setJaar(String jaar) {
        this.jaar = jaar;
    }



}
