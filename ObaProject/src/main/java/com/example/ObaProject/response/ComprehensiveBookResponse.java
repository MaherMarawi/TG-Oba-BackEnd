package com.example.ObaProject.response;


public class ComprehensiveBookResponse {

    BoekResponse largetype;
    BoekResponse audio;
    BoekResponse ebook;
    BoekResponse book;
    BoekResponse movie;

    public ComprehensiveBookResponse() {
    }

    public ComprehensiveBookResponse(BoekResponse largetype,
                                     BoekResponse audio,
                                     BoekResponse ebook,
                                     BoekResponse book,
                                     BoekResponse movie) {
        this.largetype = largetype;
        this.audio = audio;
        this.ebook = ebook;
        this.book = book;
        this.movie = movie;
    }

    public BoekResponse getLargetype() {
        return largetype;
    }

    public void setLargetype(BoekResponse largetype) {
        this.largetype = largetype;
    }

    public BoekResponse getAudio() {
        return audio;
    }

    public void setAudio(BoekResponse audio) {
        this.audio = audio;
    }

    public BoekResponse getEbook() {
        return ebook;
    }

    public void setEbook(BoekResponse ebook) {
        this.ebook = ebook;
    }

    public BoekResponse getBook() {
        return this.book;
    }

    public void setBook(BoekResponse book) {
        this.book = book;
    }

    public BoekResponse getMovie() {
        return movie;
    }

    public void setMovie(BoekResponse movie) {
        this.movie = movie;
    }


}
