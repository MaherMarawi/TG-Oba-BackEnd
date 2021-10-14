package com.example.ObaProject.response;

public class ComprehensiveCursusResponse {
    CursusResponse this_week;
    CursusResponse this_month;
    CursusResponse next_month;
    CursusResponse next_3months;
    CursusResponse this_year;

    public ComprehensiveCursusResponse(CursusResponse this_week,
                                       CursusResponse this_month,
                                       CursusResponse next_month,
                                       CursusResponse next_3months,
                                       CursusResponse this_year) {
        this.this_week = this_week;
        this.this_month = this_month;
        this.next_month = next_month;
        this.next_3months = next_3months;
        this.this_year = this_year;
    }

    public CursusResponse getThis_week() {
        return this_week;
    }

    public void setThis_week(CursusResponse this_week) {
        this.this_week = this_week;
    }

    public CursusResponse getThis_month() {
        return this_month;
    }

    public void setThis_month(CursusResponse this_month) {
        this.this_month = this_month;
    }

    public CursusResponse getNext_month() {
        return next_month;
    }

    public void setNext_month(CursusResponse next_month) {
        this.next_month = next_month;
    }

    public CursusResponse getNext_3months() {
        return next_3months;
    }

    public void setNext_3months(CursusResponse next_3months) {
        this.next_3months = next_3months;
    }

    public CursusResponse getYear() {
        return this_year;
    }

    public void setYear(CursusResponse this_year) {
        this.this_year = this_year;
    }
}
