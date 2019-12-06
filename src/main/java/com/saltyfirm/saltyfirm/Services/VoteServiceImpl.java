package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;

    @Override
    public int voteReview(boolean vote, int reviewId, int userId){

        return 0;
    }

    @Override
    public int removeVote(int reviewId, int userId){

        return 0;
    }
}
