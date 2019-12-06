package com.saltyfirm.saltyfirm.Models;

public class Vote {

    private int voteId;
    private boolean vote;

    public Vote(int voteId, boolean vote) {
        this.voteId = voteId;
        this.vote = vote;
    }

    public Vote() {
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }
}
