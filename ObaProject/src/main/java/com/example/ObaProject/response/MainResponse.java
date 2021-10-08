package com.example.ObaProject.response;

import com.example.ObaProject.data.Activiteit;
import com.example.ObaProject.data.Boek;
import com.example.ObaProject.data.Cursus;

import java.util.List;

public class MainResponse {

    private BoekResponse books;
    private ActiviteitResponse activiteiten;
    private CursusResponse cursussen;

    public MainResponse() {
    }

    public BoekResponse getBooks() {
        return books;
    }

    public void setBooks(BoekResponse books) {
        this.books = books;
    }

    public ActiviteitResponse getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(ActiviteitResponse activiteiten) {
        this.activiteiten = activiteiten;
    }

    public CursusResponse getCursussen() {
        return cursussen;
    }

    public void setCursussen(CursusResponse cursussen) {
        this.cursussen = cursussen;
    }
}
