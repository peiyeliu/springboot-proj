package com.example.movierecord.domain;


import javax.persistence.*;

/**
 * the rating entity
 */
@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    private int score;
    private String comment;

    @ManyToOne
    private Movie movie;

    public Rating(){}

    public Rating(int score, String comment){
        this.score = score;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", movieRated=" + movie +
                '}';
    }
}
