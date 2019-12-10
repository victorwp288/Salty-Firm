package com.saltyfirm.saltyfirm.Models;

public class Review {

    private int reviewId;
    private String post;
    private int salary;
    private String position;
    private int pensionScheme;
    private int benefits;
    private int management;
    private int workEnvironment;
    private int flexibility;
    private int employmentTime;

    public Review(String post, int salary, String position, int pentionScheme, int benefits, int management, int workEnvironment, int flexibility, int employmentTime) {
        this.post = post;
        this.salary = salary;
        this.position = position;
        this.pensionScheme = pentionScheme;
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

    public int getPensionScheme() {
        return pensionScheme;
    }

    public void setPensionScheme(int pentionScheme) {
        this.pensionScheme = pentionScheme;
    }

    public int getBenefits() {
        return benefits;
    }

    public void setBenefits(int benefits) {
        this.benefits = benefits;
    }

    public int getManagement() {
        return management;
    }

    public void setManagement(int management) {
        this.management = management;
    }

    public int getWorkEnvironment() {
        return workEnvironment;
    }

    public void setWorkEnvironment(int workEnvironment) {
        this.workEnvironment = workEnvironment;
    }

    public int getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(int flexibility) {
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
