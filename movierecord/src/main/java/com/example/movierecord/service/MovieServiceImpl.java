package com.example.movierecord.service;

import com.example.movierecord.domain.Movie;
import com.example.movierecord.domain.MovieRepository;
import com.example.movierecord.form.MovieSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public Page<Movie> showAllMoviesByPage(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public Movie showMovieById(long id) {
        return movieRepository.getOne(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        movieRepository.deleteAll();
    }

    @Override
    public Page<Movie> searchBy(MovieSearchForm form, Pageable pageable) {
        String country = form.getCountry();
        String title = form.getTitle();
        String genre = form.getGenre();
        String director = form.getDirector();
        return movieRepository.search(title, country, genre, director, pageable);
    }
}
