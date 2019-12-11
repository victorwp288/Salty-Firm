package com.saltyfirm.saltyfirm.Models;

import java.util.ArrayList;

public class DepartmentOverview {
    private String firmName;
    private String firmLogoUrl;
    private String firmDescription;
    private String departmentName;
    private String departmentAddress;
    private double departmentScore;
    private ArrayList<Integer> userId;
    private ArrayList<Review> reviews;

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmLogoUrl() {
        return firmLogoUrl;
    }

    public void setFirmLogoUrl(String firmLogoUrl) {
        this.firmLogoUrl = firmLogoUrl;
    }

    public String getFirmDescription() {
        return firmDescription;
    }

    public void setFirmDescription(String firmDescription) {
        this.firmDescription = firmDescription;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public double getDepartmentScore() {
        return departmentScore;
    }

    public void setDepartmentScore(double departmentScore) {
        this.departmentScore = departmentScore;
    }

    public ArrayList<Integer> getUserId() {
        return userId;
    }

    public void setUserId(ArrayList<Integer> userId) {
        this.userId = userId;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
