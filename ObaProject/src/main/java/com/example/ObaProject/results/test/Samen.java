package com.example.ObaProject.results.test;

import com.example.ObaProject.results.activiteiten.Activiteit;
import com.example.ObaProject.results.activiteiten.ActiviteitResponse;
import com.example.ObaProject.results.cursussen.Cursus;
import com.example.ObaProject.results.cursussen.CursusResponse;

import java.util.List;

public class Samen {

    private ActiviteitResponse activiteiten;
    private CursusResponse cursussen;

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
