package com.example.ObaProject.response;

public class MainResponse {

    private BoekResponse boeken;
    private ActiviteitResponse activiteiten;
    private CursusResponse cursussen;

    public MainResponse() {
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
