package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Review;

public interface ReviewRepository {

    int createReview(Review review, int userId, int departmentId);
    int editReview(Review review, int userId, int departmentId);
    int deleteReview(int reviewId);
}
