package com.example.ObaProject.results.facet;

public class Facet {
    private FacetItem[] type;
    private FacetItem[] activiteiten;
    private FacetItem[] doelgroep;
    private FacetItem[] auteur;
    private FacetItem[] genre;
    private FacetItem[] topic;
    private FacetItem[] language;
    private FacetItem[] pubYear;
    private FacetItem[] pubYearRange;

    public Facet() {
    }

    public FacetItem[] getType() {
        return type;
    }

    public void setType(FacetItem[] type) {
        this.type = type;
    }

    public FacetItem[] getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(FacetItem[] activiteiten) {
        this.activiteiten = activiteiten;
    }

    public FacetItem[] getDoelgroep() {
        return doelgroep;
    }

    public void setDoelgroep(FacetItem[] doelgroep) {
        this.doelgroep = doelgroep;
    }

    public FacetItem[] getAuteur() {
        return auteur;
    }

    public void setAuteur(FacetItem[] auteur) {
        this.auteur = auteur;
    }

    public FacetItem[] getGenre() {
        return genre;
    }

    public void setGenre(FacetItem[] genre) {
        this.genre = genre;
    }

    public FacetItem[] getTopic() {
        return topic;
    }

    public void setTopic(FacetItem[] topic) {
        this.topic = topic;
    }

    public FacetItem[] getLanguage() {
        return language;
    }

    public void setLanguage(FacetItem[] language) {
        this.language = language;
    }

    public FacetItem[] getPubYear() {
        return pubYear;
    }

    public void setPubYear(FacetItem[] pubYear) {
        this.pubYear = pubYear;
    }

    public FacetItem[] getPubYearRange() {
        return pubYearRange;
    }

    public void setPubYearRange(FacetItem[] pubYearRange) {
        this.pubYearRange = pubYearRange;
    }
}
