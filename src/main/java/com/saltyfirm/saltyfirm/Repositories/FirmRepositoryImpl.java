package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FirmRepositoryImpl implements FirmRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Firm> searchFirms(String word) {

        List<Firm> firmList = new ArrayList<>();


        try{
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.firm WHERE firm_name = ?");

            preparedStatement.setString(1, word);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Firm firm = new Firm();

                firm.setFirmId(resultSet.getInt("firm_id"));
                firm.setFirmName(resultSet.getString("firm_name"));
                firm.setFirmType(resultSet.getString("firm_type"));
                firm.setOverallScore(resultSet.getDouble("overall_score"));
                firm.setDescription(resultSet.getString("description"));
                firm.setLogoURL(resultSet.getString("logo_url"));

                firmList.add(firm);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return firmList;
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
    public void editFirm(String firmName, String firmType, String description, String logourl, int firmId) {

        try{
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.firm SET firm_name = ?, firm_type = ?, description = ?, logo_url = ? WHERE firm_id = ?");
            preparedStatement.setString(1, firmName);
            preparedStatement.setString(2, firmType);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, logourl);
            preparedStatement.setInt(5, firmId);

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            log.info("he");
        }
    }
}
