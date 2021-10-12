package com.example.ObaProject.data;

public class Meta {
    private String count;
    private String page;

    public Meta() {
    }

    public Meta(String count, String page) {
        this.count = count;
        this.page = page;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
