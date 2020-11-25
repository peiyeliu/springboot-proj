package com.example.movierecord.service;

import com.example.movierecord.domain.Movie;
import com.example.movierecord.form.MovieSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    Page<Movie> showAllMoviesByPage(Pageable pageable);
    Movie showMovieById(long id);
    Movie saveMovie(Movie movie);
    void deleteMovieById(long id);
    void deleteAll();
    Page<Movie> searchBy(MovieSearchForm form, Pageable pageable);
}
