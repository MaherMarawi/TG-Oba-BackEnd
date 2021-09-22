package com.example.ObaProject.response.result;


import java.util.ArrayList;

public class Res {

    private String detail_page;
    private String[] types;
    private String[] formats;
    private String[] notes;
    private String[] coverimages;
    private String[] languages;
    private String[] undup_info;
    private String[] identifiers;
    private String[] subjects;
    private String[] description;
    private String[] titles;
    private String[] classification;
    private String[] frabl;
    private String[] series;
    private String[] publication;
    private String[] id;
    private String[] authors;
    private String[] summaries;
    private String[] genres;

    public Res() {
    }
    public void setDetail_page(String detail_page) {
        this.detail_page = detail_page;
    }
    public void setTypes(String types) {
        this.types = getArray(types);
    }
    public void setFormats(String formats) {
        this.formats = getArray(formats);
    }
    public void setNotes(String notes) {
        this.notes = getArray(notes);
    }
    public void setCoverimages(String coverimages) {
        this.coverimages = getArray(coverimages);
    }
    public void setLanguages(String languages) {
        this.languages = getArray(languages);
    }
    public void setUndup_info(String undup_info) {
        this.undup_info = getArray(undup_info);
    }
    public void setIdentifiers(String identifiers) {
        this.identifiers = getArray(identifiers);
    }
    public void setSubjects(String subjects) {
        this.subjects = getArray(subjects);
    }
    public void setDescription(String description) {
        this.description = getArray(description);
    }
    public void setTitles(String titles) {
        this.titles = getArray(titles);
    }
    public void setFrabl(String frabl) {
        this.frabl = getArray(frabl);
    }
    public void setSeries(String series) {
        this.series = getArray(series);
    }
    public void setPublication(String publication) {
        this.publication = getArray(publication);
    }
    public void setId(String id) {
        this.id = getArray(id);
    }
    public void setAuthors(String authors) {
        this.authors = getArray(authors);
    }
    public void setSummaries(String summaries) {
        this.summaries = getArray(summaries);
    }
    public void setGenres(String genres) {
        this.genres = getArray(genres);
    }
    public void setClassification(String classification) {
        this.classification = getArray(classification);
    }

    public String getDetail_page() {
        return detail_page;
    }
    public String[] getTypes() {
        return types;
    }
    public String[] getFormats() {
        return formats;
    }
    public String[] getNotes() {
        return notes;
    }
    public String[] getCoverimages() {
        return coverimages;
    }
    public String[] getLanguages() {
        return languages;
    }
    public String[] getUndup_info() {
        return undup_info;
    }
    public String[] getIdentifiers() {
        return identifiers;
    }
    public String[] getSubjects() {
        return subjects;
    }
    public String[] getDescription() {
        return description;
    }
    public String[] getTitles() {
        return titles;
    }
    public String[] getClassification() {
        return classification;
    }
    public String[] getFrabl() {
        return frabl;
    }
    public String[] getSeries() {
        return series;
    }
    public String[] getPublication() {
        return publication;
    }
    public String[] getId() {
        return id;
    }
    public String[] getAuthors() {
        return authors;
    }
    public String[] getSummaries() {
        return summaries;
    }
    public String[] getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Res{" +
                "detail_page='" + detail_page + '\'' +
                ", types='" + types + '\'' +
                ", formats='" + formats + '\'' +
                ", notes='" + notes + '\'' +
                ", coverimages='" + coverimages + '\'' +
                ", languages='" + languages + '\'' +
                ", undup_info='" + undup_info + '\'' +
                ", identifiers='" + identifiers + '\'' +
                ", subjects='" + subjects + '\'' +
                ", description='" + description + '\'' +
                ", titles='" + titles + '\'' +
                ", classification='" + classification + '\'' +
                ", frabl='" + frabl + '\'' +
                ", series='" + series + '\'' +
                ", publication='" + publication + '\'' +
                ", id='" + id + '\'' +
                ", authors='" + authors + '\'' +
                ", summaries='" + summaries + '\'' +
                ", genres='" + genres + '\'' +
                '}';
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
