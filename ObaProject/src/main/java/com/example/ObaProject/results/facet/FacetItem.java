package com.example.ObaProject.results.facet;

public class FacetItem {
    private String count;
    private String id;

    public FacetItem(String count, String id) {
        this.count = count;
        this.id = id;
    }

    public FacetItem() {
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
