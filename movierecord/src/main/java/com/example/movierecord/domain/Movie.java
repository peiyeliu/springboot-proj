package com.example.movierecord.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the movie entity
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private int year;
    private String country;
    private String genre;
    private String director;
    private int minutes;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Rating> ratingList = new ArrayList<>();

    public Movie() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }


    /**
     *
     * @param rating
     */
    public void addRating(Rating rating){
        rating.setMovie(this);
        ratingList.add(rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", minutes='" + minutes + '\'' +
                '}';
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
