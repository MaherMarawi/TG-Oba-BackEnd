package com.example.ObaProject.data;

import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.response.ComprehensiveActivityResponse;
import com.example.ObaProject.response.ComprehensiveCursusResponse;
import com.example.ObaProject.response.CursusResponse;

public class Samen {

    private ComprehensiveActivityResponse activiteiten;
    private ComprehensiveCursusResponse cursussen;

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
