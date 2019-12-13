package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Review;

import java.util.List;

public interface ReviewService {
    int createReview(Review review, int userId, int departmentId);
    int editReview(Review review, int departmentId);
    int deleteReview(int reviewId, int departmentId);
    List<Review> fetchUserReview(int userId);
}