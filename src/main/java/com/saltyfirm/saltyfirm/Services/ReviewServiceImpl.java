package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review findReviewById(int reviewId) {
        return reviewRepository.findReviewById(reviewId);
    }

    @Override
    public int createReview(Review review, int userId, int departmentId) {
        return reviewRepository.createReview(review, userId, departmentId);
    }

    @Override
    public int editReview(Review review, int departmentId) {
        return reviewRepository.editReview(review, departmentId);
    }

    @Override
    public int deleteReview(int reviewId) {
        return reviewRepository.deleteReview(reviewId);
    }

    @Override
    public List<Review> fetchUserReview(int userId) {
        return reviewRepository.fetchUserReview(userId);
    }
}
