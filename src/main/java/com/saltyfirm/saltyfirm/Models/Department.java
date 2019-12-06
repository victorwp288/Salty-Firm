package com.saltyfirm.saltyfirm.Models;

public class Department {

    private int departmentId;
    private String departmentName;
    private String departmentAddress;
    private double departmentScore;

    public Department(int departmentId, String departmentName, String departmentAddress, double departmentScore) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentScore = departmentScore;
    }

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
}
