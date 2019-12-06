package com.saltyfirm.saltyfirm.Services;

public interface ReviewService {
    int createReview(int userId, int reviewId, String post, int salary, String position, int pensionScheme, int benefits, int management, int workEnvironment, int flexibility);
    int editReview(int userId, int reviewId, String post, int salary, String position, int pensionScheme, int benefits, int management, int workEnvironment, int flexibility);
    int deleteReview(int reviewId);
}
