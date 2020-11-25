package com.example.movierecord.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query("update Movie m set m.title = ?2 where m.id= ?1")
    int updateTitleById(long id, String title);

    @Modifying
    @Transactional
    @Query("update Movie m set m.year = ?2 where m.id= ?1")
    int updateYearById(long id, int year);

    @Modifying
    @Transactional
    @Query("update Movie m set m.country = ?2 where m.id= ?1")
    int updateCountryById(long id, String country);

    @Modifying
    @Transactional
    @Query("update Movie m set m.genre = ?2 where m.id= ?1")
    int updateGenreById(long id, String genre);

    @Modifying
    @Transactional
    @Query("update Movie m set m.director = ?2 where m.id= ?1")
    int updateDirectorById(long id, String director);

    @Modifying
    @Transactional
    @Query("update Movie m set m.minutes = ?2 where m.id= ?1")
    int updateMinutesById(long id, int minutes);

    @Query("select m from Movie m where m.title like ?1 and m.country like ?2 and m.genre like ?3 and m.director like ?4")
    Page<Movie> search(String title, String country, String genre, String director, Pageable pageable);

}
