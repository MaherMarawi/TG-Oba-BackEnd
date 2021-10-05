package com.example.ObaProject.response;


import com.example.ObaProject.results.Result;
import com.example.ObaProject.results.activiteiten.Activiteit;
import com.example.ObaProject.results.boeken.Boek;
import com.example.ObaProject.results.cursussen.Cursus;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Response {

    private List<Boek> boeken;
    private List<Activiteit> activiteiten;
    private List<Cursus> cursussen;

    public Response() {
    }

    public Response(List<Boek> boeken,
                    List<Activiteit> activiteiten,
                    List<Cursus> cursussen) {
        this.boeken = boeken;
        this.activiteiten = activiteiten;
        this.cursussen = cursussen;
    }
    public void setBoeken(List<Boek> boeken) {
        this.boeken = boeken;
    }
    public void setActiviteiten(List<Activiteit> activiteiten) {
        this.activiteiten = activiteiten;
    }
    public void setCursussen(List<Cursus> cursussen) {
        this.cursussen = cursussen;
    }


    public List<Boek> getBoeken() {
        return boeken;
    }
    public List<Activiteit> getActiviteiten() {
        return activiteiten;
    }
    public List<Cursus> getCursussen() {
        return cursussen;
    }
}
