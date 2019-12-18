package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Vote;
import com.saltyfirm.saltyfirm.Repositories.DatabaseConnection.DbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Victor Petersen | Patrick Jønsson
@Repository("VoteRepositoryImpl")
public class VoteRepositoryImpl implements VoteRepository {

    @Autowired
    DbHandler dbHandler;

    @Override
    public int voteReview(boolean vote, int reviewId, int userId) {
        List<Vote> votes = new ArrayList<>();
        int counter = 0;

        try {
            Connection connection = dbHandler.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM saltyfirm.vote WHERE saltyfirm.review_fk_id = ?");

            Vote currentVote = new Vote();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeVote(int reviewId, int userId) {

        return 0;
    }

    public int voteOnReview(boolean vote, int reviewId, int userId) {
        List<Vote> votes = new ArrayList<>();
        int counter = 0;

        try {
            Connection connection = dbHandler.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM saltyfirm.vote WHERE saltyfirm.review_fk_id = ?");

            Vote currentVote = new Vote();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
