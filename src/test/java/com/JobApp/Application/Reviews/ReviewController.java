package com.JobApp.Application.Reviews;

import com.JobApp.Application.Companies.CompanyService;
import com.JobApp.Application.Reviews.impl.ReviewServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    ReviewService reviewService ;
    CompanyService companyService ;

    public ReviewController(ReviewService reviewService, CompanyService companyService) {
        this.reviewService = reviewService;
        this.companyService = companyService;
    }

    @GetMapping("/companies/{companyId}/reviews")
    public ResponseEntity<List<Review>> showAllReviews (@PathVariable Long comapnyId) {
        return new ResponseEntity<>(reviewService.findAllReviews(comapnyId),HttpStatus.OK) ;
    }

    @PostMapping("/companies/{companyId}/reviews")
    public ResponseEntity<String> addReview (@PathVariable Long companyId , @RequestBody Review review){
        if (review.getCompanyId()==null){
            review.setCompanyId(companyId);
        }
        reviewService.createReview(review);
        return new ResponseEntity<>("Review added",HttpStatus.OK) ;
    }

    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById (@PathVariable Long companyId , @PathVariable Long reviewId){
        Review review = reviewService.findById(reviewId) ;
        if (review==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
    }

    @PutMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById (@PathVariable Long companyId , @PathVariable Long reviewId){
        Review review = reviewService.findById(reviewId);
        boolean query = reviewService.updateReview(companyId,review);
        if (query){
            return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
        }
    }
    
}
