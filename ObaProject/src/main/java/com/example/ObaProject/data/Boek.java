package com.example.ObaProject.data;

import java.util.ArrayList;

public class Boek extends Result {

    private String[] auteurs;
    private String uitgave_jaar;
    private String uitgever;
    private String taal;
    private String doelgroep;
    private String series;

    public Boek() {
    }



    public String[] getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = getArray(auteurs);
    }

    public String getUitgave_jaar() {
        return uitgave_jaar;
    }

    public void setUitgave_jaar(String uitgave_jaar) {
        this.uitgave_jaar = uitgave_jaar;
    }

    public String getUitgever() {
        return uitgever;
    }

    public void setUitgever(String uitgever) {
        this.uitgever = uitgever;
    }

    public String getTaal() {
        return taal;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }

    public String getDoelgroep() {
        return doelgroep;
    }

    public void setDoelgroep(String doelgroep) {
        this.doelgroep = doelgroep;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    public static String[] getArray(String str) {

        String strReplace = str.trim().replaceAll("\n", ",");
        ArrayList strResult = new ArrayList();
        for (String w : strReplace.split(",")) {
            if (w.trim() != "")
                strResult.add(w.trim());
        }
        String[] str2 = new String[strResult.size()];
        str2 = (String[]) strResult.toArray(str2);
        return str2;
    }
}
