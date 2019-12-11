package com.saltyfirm.saltyfirm.Models;

import java.util.ArrayList;

public class FirmOverview {
    private String firmName;
    private String firmLogoURL;
    private String firmType;
    private String firmDescription;
    private double overAllScore;
    private ArrayList<Department> departments;

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmLogoURL() {
        return firmLogoURL;
    }

    public void setFirmLogoURL(String firmLogoURL) {
        this.firmLogoURL = firmLogoURL;
    }

    public String getFirmType() {
        return firmType;
    }

    public void setFirmType(String firmType) {
        this.firmType = firmType;
    }

    public String getFirmDescription() {
        return firmDescription;
    }

    public void setFirmDescription(String firmDescription) {
        this.firmDescription = firmDescription;
    }

    public double getOverAllScore() {
        return overAllScore;
    }

    public void setOverAllScore(double overAllScore) {
        this.overAllScore = overAllScore;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
}