package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Review;

import java.util.List;

public interface ReviewRepository {

    Review findReviewById(int reviewId);
    int createReview(Review review, int userId);
    int editReview(Review review, int departmentId);
    int deleteReview(int reviewId);
    List<Review> fetchUserReview(int userId);
}
