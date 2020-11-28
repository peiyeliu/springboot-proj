package com.example.movierecord.service;

import com.example.movierecord.domain.Movie;
import com.example.movierecord.domain.MovieRepository;
import com.example.movierecord.form.MovieSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public Page<Movie> queryBy(String title, String country, String genre, String director, Pageable pageable) {
        Specification<Movie> movieSpecification = new Specification<Movie>() {
            @Override
            public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (title != null) {
                    list.add(criteriaBuilder.like(root.get("title").as(String.class), "%" + title + "%"));
                }
                if (country != null) {
                    list.add(criteriaBuilder.like(root.get("country").as(String.class), "%" + country + "%"));
                }
                if (genre != null) {
                    list.add(criteriaBuilder.like(root.get("genre").as(String.class), "%" + genre + "%"));
                }
                if (director != null) {
                    list.add(criteriaBuilder.like(root.get("director").as(String.class), "%" + director + "%"));
                }
                Predicate[] predicates = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(predicates));
            }
        };
        return movieRepository.findAll(movieSpecification, pageable);
    }

}
