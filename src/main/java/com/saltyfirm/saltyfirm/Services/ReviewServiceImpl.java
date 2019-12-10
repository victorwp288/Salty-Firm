package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public int createReview(int userId, int reviewId, String post, int salary, String position, int pensionScheme, int benefits, int management, int workEnvironment, int flexibility) {
        return reviewRepository.createReview(userId, reviewId, post, salary, position, pensionScheme, benefits, management, workEnvironment, flexibility);
    }

    @Override
    public int editReview(int userId, int reviewId, String post, int salary, String position, int pensionScheme, int benefits, int management, int workEnvironment, int flexibility) {
        return reviewRepository.editReview(userId, reviewId, post, salary, position, pensionScheme, benefits, management, workEnvironment, flexibility);
    }

    @Override
    public int deleteReview(int reviewId) {
        return reviewRepository.deleteReview(reviewId);
    }
}
