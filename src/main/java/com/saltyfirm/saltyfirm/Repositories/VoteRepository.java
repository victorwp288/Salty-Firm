package com.saltyfirm.saltyfirm.Repositories;

public interface VoteRepository {

    int voteReview(boolean vote, int reviewId, int userId);

    int removeVote(int reviewId, int userId);
}
