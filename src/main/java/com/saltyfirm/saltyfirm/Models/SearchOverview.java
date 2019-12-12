package com.saltyfirm.saltyfirm.Models;

public class SearchOverview {
    private String firmName;
    private String firmLogoUrl;
    private double totalScore;

    public SearchOverview(String firmName, String firmLogoUrl, double totalScore) {
        this.firmName = firmName;
        this.firmLogoUrl = firmLogoUrl;
        this.totalScore = totalScore;
    }

    public SearchOverview(){}

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

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "SearchOverview{" +
                "firmName='" + firmName + '\'' +
                ", firmLogoUrl='" + firmLogoUrl + '\'' +
                ", totalScore=" + totalScore +
                '}';
    }
}
