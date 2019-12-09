package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class FirmRepositoryImpl implements FirmRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String searchFirms(String word) {

        return null;
    }

    @Override
    public Firm findFirmById(int firmId) {

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.firm WHERE firm_id = ?");

            preparedStatement.setInt(1, firmId);
            ResultSet resultSet = preparedStatement.executeQuery();

            log.info("before if");
            if(resultSet.next()) {
                Firm firm = new Firm();

                firm.setFirmId(resultSet.getInt("firm_id"));
                firm.setFirmName(resultSet.getString("firm_name"));
                firm.setFirmType(resultSet.getString("firm_type"));
                firm.setOverallScore(resultSet.getDouble("overall_score"));
                firm.setDescription(resultSet.getString("description"));
                firm.setLogoURL(resultSet.getString("logo_url"));
                return firm;
            } else {
                log.info("Didnt find anything");
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("fandt ingen firm");
        return null;
    }

    @Override
    public int deleteFirm(int id) {
        try {
            log.info("Køre deleteFirm");
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.firm WHERE firm_id = ?");
            preparedStatement.setInt(1, id);

            log.info("Executed deleteFirm");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("fangede en exeption");
        }
        log.info("Lortet virkede ikke");
        return 0;
    }

    @Override
    public int editFirm(int firmId, String firmName, String firmType, double overallScore, String description, String logoURL) {

        return 0;
    }


}
