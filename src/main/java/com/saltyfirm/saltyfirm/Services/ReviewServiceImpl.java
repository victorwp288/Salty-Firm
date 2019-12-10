package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public int createReview(Review review, int userId, int departmentId) {
        return reviewRepository.createReview(review, userId, departmentId);
    }

    @Override
    public int editReview(Review review) {
        return reviewRepository.editReview(review);
    }

    @Override
    public int deleteReview(int reviewId) {
        return reviewRepository.deleteReview(reviewId);
    }
}
