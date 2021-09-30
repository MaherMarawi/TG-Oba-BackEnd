package com.example.ObaProject.results.facet;

public class FacetItem {
    private String Count;
    private String id;

    public FacetItem(String count, String id) {
        Count = count;
        this.id = id;
    }

    public FacetItem() {
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
