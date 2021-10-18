package com.example.ObaProject.response;

import java.util.List;

public class ZoekResponse {
    BoekResponse boeken;
    ActiviteitResponse activiteiten;
    CursusResponse cursussen;

    public ZoekResponse() {
    }

    public BoekResponse getBoeken() {
        return boeken;
    }

    public void setBoeken(BoekResponse boeken) {
        this.boeken = boeken;
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
