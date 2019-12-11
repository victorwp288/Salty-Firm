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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.firm WHERE firm_name LIKE ?");

            preparedStatement.setString(1, "%" + word + "%");
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
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int editFirm(Firm firm) {
        try{
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.firm SET firm_name = ?, firm_type = ?, description = ?, logo_url = ? WHERE firm_id = ?");
            preparedStatement.setString(1, firm.getFirmName());
            preparedStatement.setString(2, firm.getFirmType());
            preparedStatement.setString(3, firm.getDescription());
            preparedStatement.setString(4, firm.getLogoURL());
            preparedStatement.setInt(5, firm.getFirmId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getFirmTotalScore(int firmId) {
        int amount = 0; int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT department_score FROM saltyfirm.department WHERE firm_fk_id = ?");
            preparedStatement.setInt(1, firmId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double current = resultSet.getInt(1);
                if (current > 0) {
                    amount += current;
                    counter++;
                }

            }

            return ((double) amount/counter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
