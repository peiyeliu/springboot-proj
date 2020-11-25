package com.example.movierecord.service;

import com.example.movierecord.domain.Rating;
import com.example.movierecord.domain.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Page<Rating> showAllRatingsByPage(long id, Pageable pageable) {
        return ratingRepository.findRatingByMovie_Id(id, pageable);
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating findRating(long id) {
        return ratingRepository.getOne(id);
    }

    @Override
    public void deleteRating(long id) {
        ratingRepository.deleteById(id);
    }
}
