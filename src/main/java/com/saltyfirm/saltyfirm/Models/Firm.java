package com.saltyfirm.saltyfirm.Models;

public class Firm {

    private int firmId;
    private String firmName;
    private String firmType;
    private double overallScore;
    private String description;
    private String logoURL;

    public Firm(int firmId, String firmName, String firmType, double overallScore, String description, String logoURL) {
        this.firmId = firmId;
        this.firmName = firmName;
        this.firmType = firmType;
        this.overallScore = overallScore;
        this.description = description;
        this.logoURL = logoURL;
    }

    public Firm() {
    }

    public int getFirmId() {
        return firmId;
    }

    public void setFirmId(int firmId) {
        this.firmId = firmId;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmType() {
        return firmType;
    }

    public void setFirmType(String firmType) {
        this.firmType = firmType;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }
}
