package com.example.movierecord;

import com.example.movierecord.domain.Movie;
import com.example.movierecord.domain.Rating;
import com.example.movierecord.service.MovieService;
import com.example.movierecord.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RatingTests {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RatingService ratingService;

    @Test
    public void saveRating(){
        Movie movie = new Movie();
        movie.setCountry("UK");
        movie.setTitle("Dummy2");
        movie.setGenre("Boring");
        movie.setYear(2000);
        movie.setDirector("Null Pointer");

        Rating rating1 =  new Rating(10, "good");
        Rating rating2 = new Rating(2, "bad");

        movie.addRating(rating1);
        movie.addRating(rating2);

        movieService.saveMovie(movie);
    }
    /*
    public void updateMovieRating(){
        Rating rating = ratingService.findRating(1l);
        rating.setComment("maybe");
    }

    public void deleteMovieRating(){
        long id = 2l;
        ratingService.deleteRating(id);
    }

     */
}
