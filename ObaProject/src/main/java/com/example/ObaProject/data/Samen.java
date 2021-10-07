package com.example.ObaProject.data;

import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.response.CursusResponse;

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
