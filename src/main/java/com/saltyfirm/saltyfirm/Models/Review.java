package com.saltyfirm.saltyfirm.Models;

public class Review {

    private int reviewId;
    private String post;
    private int salary;
    private String position;
    private double pensionScheme;
    private double benefits;
    private double management;
    private double workEnvironment;
    private double flexibility;
    private int employmentTime;

    public Review(String post, int salary, String position, double pensionScheme, double benefits, double management, double workEnvironment, double flexibility, int employmentTime) {
        this.post = post;
        this.salary = salary;
        this.position = position;
        this.pensionScheme = pensionScheme;
        this.benefits = benefits;
        this.management = management;
        this.workEnvironment = workEnvironment;
        this.flexibility = flexibility;
        this.employmentTime = employmentTime;
    }

    public Review() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPensionScheme() {
        return pensionScheme;
    }

    public void setPensionScheme(double pensionScheme) {
        this.pensionScheme = pensionScheme;
    }

    public double getBenefits() {
        return benefits;
    }

    public void setBenefits(double benefits) {
        this.benefits = benefits;
    }

    public double getManagement() {
        return management;
    }

    public void setManagement(double management) {
        this.management = management;
    }

    public double getWorkEnvironment() {
        return workEnvironment;
    }

    public void setWorkEnvironment(double workEnvironment) {
        this.workEnvironment = workEnvironment;
    }

    public double getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(double flexibility) {
        this.flexibility = flexibility;
    }

    public int getEmploymentTime() {
        return employmentTime;
    }

    public void setEmploymentTime(int employmentTime) {
        this.employmentTime = employmentTime;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", pensionScheme=" + pensionScheme +
                ", benefits=" + benefits +
                ", management=" + management +
                ", workEnvironment=" + workEnvironment +
                ", flexibility=" + flexibility +
                ", employmentTime=" + employmentTime +
                '\n';
    }
}
