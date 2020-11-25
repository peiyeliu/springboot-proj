package com.example.movierecord.service;

import com.example.movierecord.domain.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface RatingService {
    Page<Rating> showAllRatingsByPage(long id, Pageable pageable);

    Rating saveRating(Rating rating);

    Rating updateRating(Rating rating);

    Rating findRating(long id);

    void deleteRating(long id);
}
