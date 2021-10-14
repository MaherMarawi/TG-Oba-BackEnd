package com.example.ObaProject.response;

public class ComprehensiveActivityResponse {
    ActiviteitResponse next_week;
    ActiviteitResponse this_month;
    ActiviteitResponse next_month;
    ActiviteitResponse next_3months;
    ActiviteitResponse this_year;

    public ComprehensiveActivityResponse(ActiviteitResponse next_week,
                                         ActiviteitResponse this_month,
                                         ActiviteitResponse next_month,
                                         ActiviteitResponse next_3months,
                                         ActiviteitResponse this_year) {
        this.next_week = next_week;
        this.this_month = this_month;
        this.next_month = next_month;
        this.next_3months = next_3months;
        this.this_year = this_year;
    }

    public ActiviteitResponse getNext_week() {
        return next_week;
    }

    public void setNext_week(ActiviteitResponse next_week) {
        this.next_week = next_week;
    }

    public ActiviteitResponse getThis_month() {
        return this_month;
    }

    public void setThis_month(ActiviteitResponse this_month) {
        this.this_month = this_month;
    }

    public ActiviteitResponse getNext_month() {
        return next_month;
    }

    public void setNext_month(ActiviteitResponse next_month) {
        this.next_month = next_month;
    }

    public ActiviteitResponse getNext_3months() {
        return next_3months;
    }

    public void setNext_3months(ActiviteitResponse next_3months) {
        this.next_3months = next_3months;
    }

    public ActiviteitResponse getYear() {
        return this_year;
    }

    public void setYear(ActiviteitResponse this_year) {
        this.this_year = this_year;
    }
}
