package com.example.ObaProject.data;

public class Cursus extends Result {

    private String info;
    private String prijs;
    private String bijlesdocent;

    public Cursus() {
    }

    public String getInfo() {
        return info;
    }
    public String getPrijs() {
        return prijs;
    }
    public String getBijlesdocent() {
        return bijlesdocent;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }
    public void setBijlesdocent(String bijlesdocent) {
        this.bijlesdocent = getString(bijlesdocent);
    }

    public static String getString(String str) {

        String strReplace = str.trim().replaceAll("\n", "");
        return strReplace.trim();
    }
}
