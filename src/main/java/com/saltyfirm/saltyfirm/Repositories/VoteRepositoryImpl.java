package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Vote;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoteRepositoryImpl implements VoteRepository {

    @Override
    public int voteReview(boolean vote, int reviewId, int userId) {
        List<Vote> votes = new ArrayList<>();
        int counter = 0;

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
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
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM saltyfirm.vote WHERE saltyfirm.review_fk_id = ?");

            Vote currentVote = new Vote();






        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
