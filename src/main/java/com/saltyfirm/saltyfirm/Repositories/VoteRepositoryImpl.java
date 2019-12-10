package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class VoteRepositoryImpl implements VoteRepository {

    public int voteReview(boolean vote, int reviewId, int userId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int removeVote(int reviewId, int userId) {

        return 0;
    }
}
