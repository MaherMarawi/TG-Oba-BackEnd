package com.example.ObaProject.response;

public class MainResponse {

    private ComprehensiveBookResponse boeken;
    private ComprehensiveActivityResponse activiteiten;
    private ComprehensiveCursusResponse cursussen;

    public MainResponse() {
    }


    public ComprehensiveBookResponse getBoeken() {
        return boeken;
    }

    public void setBoeken(ComprehensiveBookResponse boeken) {
        this.boeken = boeken;
    }

    public ComprehensiveActivityResponse getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(ComprehensiveActivityResponse activiteiten) {
        this.activiteiten = activiteiten;
    }

    public ComprehensiveCursusResponse getCursussen() {
        return cursussen;
    }

    public void setCursussen(ComprehensiveCursusResponse cursussen) {
        this.cursussen = cursussen;
    }
}
