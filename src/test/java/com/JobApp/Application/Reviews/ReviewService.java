package com.JobApp.Application.Reviews;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews (Long id) ;
    Review findById (Long id) ;
    void createReview (Review rev);
    boolean updateReview (Long id , Review rev);
    boolean deleteReview (Long id) ;
}
