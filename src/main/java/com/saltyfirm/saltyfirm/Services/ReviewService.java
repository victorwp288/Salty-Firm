package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Review;

public interface ReviewService {
    int createReview(Review review, int userId, int departmentId);
    int editReview(Review review, int userId, int departmentId);
    int deleteReview(int reviewId);
}
