package com.saltyfirm.saltyfirm.Services;

public interface VoteService {

    int voteReview(boolean vote, int reviewId, int userId);
    int removeVote(int reviewId, int userId);
}
