package com.saltyfirm.saltyfirm.Services;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Override
    public int createReview(int userId, int reviewId, String post, int salary, String position, int pentionScheme, int benefits, int management, int workEnvironment, int flexibility) {
        return 0;
    }

    @Override
    public int editReview(int userId, int reviewId, String post, int salary, String position, int pentionScheme, int benefits, int management, int workEnvironment, int flexibility) {
        return 0;
    }

    @Override
    public int deleteReview(int reviewId) {
        return 0;
    }
}
