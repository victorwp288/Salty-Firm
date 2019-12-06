package com.saltyfirm.saltyfirm.Services;

import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Override
    public int voteReview(boolean vote, int reviewId, int userId){

        return 0;
    }

    @Override
    public int removeVote(int reviewId, int userId){

        return 0;
    }
}
