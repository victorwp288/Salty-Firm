package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Review;

import java.util.List;

public interface ReviewService {
    Review findReviewById(int reviewId);
    int createReview(Review review, int userId);
    int editReview(Review review);
    int deleteReview(int reviewId);
    List<Review> fetchUserReview(int userId);
}