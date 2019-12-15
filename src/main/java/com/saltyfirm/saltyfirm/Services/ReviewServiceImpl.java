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
    public int createReview(Review review, int userId) {
        return reviewRepository.createReview(review, userId);
    }

    @Override
    public int editReview(Review review) {
        return reviewRepository.editReview(review);
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
