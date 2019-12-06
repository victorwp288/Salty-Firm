package com.saltyfirm.saltyfirm.Repositories;

import org.springframework.stereotype.Service;

@Service
public class ReviewRepositoryImpl implements ReviewRepository{


    public int createReview(int userId, int reviewId, String post, int salary, String position, int pensionScheme, int benefits, int management, int workEnvironment, int flexibility) {

        return 0;
    }

    public int editReview(int userId, int reviewId, String post, int salary, String position, int pensionScheme, int benefits, int management, int workEnvironment, int flexibility) {

        return 0;
    }

    public int deleteReview(int reviewId) {

        return 0;
    }

}
