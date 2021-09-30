package com.example.ObaProject.results;

import java.util.ArrayList;

public class Result {

    private String jaar;
    private String title;
    private String beschrijving;
    private String detailPagina;
    private String[] omslagafbeeldingen;
    private String locatie;

    public String getJaar() {
        return jaar;
    }

    public void setJaar(String jaar) {
        this.jaar = jaar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = getString(beschrijving);
    }

    public String getDetailPagina() {
        return detailPagina;
    }

    public void setDetailPagina(String detailPagina) {
        this.detailPagina = detailPagina;
    }

    public String[] getOmslagafbeeldingen() {
        return omslagafbeeldingen;
    }

    public void setOmslagafbeeldingen(String omslagafbeeldingen) {
        this.omslagafbeeldingen = getArray(omslagafbeeldingen);
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
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
    public static String getString(String str) {

        String strReplace = str.trim().replaceAll("\n", "");
        return strReplace.trim();
    }
}
