package com.saltyfirm.saltyfirm.Models;

public class Department {

    private int departmentId;
    private String departmentName;
    private String departmentAdress;
    private double departmentScore;
    int a;

    public Department(int departmentId, String departmentName, String departmentAdress, double departmentScore) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAdress = departmentAdress;
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

    public String getDepartmentAdress() {
        return departmentAdress;
    }

    public void setDepartmentAdress(String departmentAdress) {
        this.departmentAdress = departmentAdress;
    }

    public double getDepartmentScore() {
        return departmentScore;
    }

    public void setDepartmentScore(double departmentScore) {
        this.departmentScore = departmentScore;
    }
}
