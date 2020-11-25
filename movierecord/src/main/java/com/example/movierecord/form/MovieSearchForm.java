package com.example.movierecord.form;

import javax.validation.constraints.NotNull;

public class MovieSearchForm {

    @NotNull
    private String title;
    @NotNull
    private String country;
    @NotNull
    private String genre;
    @NotNull
    private String director;

    public MovieSearchForm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
