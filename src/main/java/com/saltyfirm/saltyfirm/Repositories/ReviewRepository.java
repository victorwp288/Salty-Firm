package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Review;

import java.util.List;

public interface ReviewRepository {

    int createReview(Review review, int userId, int departmentId);
    int editReview(Review review, int departmentId);
    int deleteReview(int reviewId, int departmentId);
    List<Review> fetchUserReview(int userId);
}
