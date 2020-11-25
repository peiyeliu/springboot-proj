package com.example.movierecord.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("select distinct r from Rating r where r.movie.id = ?1")
    Page<Rating> findRatingByMovie_Id(long id, Pageable pageable);
}
