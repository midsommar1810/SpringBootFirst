package com.JobApp.Application.Reviews.impl;

import com.JobApp.Application.Reviews.Review;
import com.JobApp.Application.Reviews.ReviewRepository;
import com.JobApp.Application.Reviews.ReviewService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService {
    ReviewRepository reviewRepository ;

    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAllReviews(Long id) {
        List<Review> f = new ArrayList<>() ;
        for (Review review : reviewRepository.findAll()){
            if ( review.getCompanyId() == id ){
                f.add(review) ;
            }
        }
        return f ;
    }

    @Override
    public Review findById(Long id) {
        Optional<Review> review = reviewRepository.findById(id) ;
        if (review.isPresent()){
            return review.get() ;
        } else {
            return null ;
        }
    }

    @Override
    public void createReview(Review rev) {

    }

    @Override
    public boolean updateReview(Long id, Review rev) {
        return false;
    }

    @Override
    public boolean deleteReview(Long id) {
        return false;
    }
}
