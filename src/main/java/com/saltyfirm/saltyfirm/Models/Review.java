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

    public Review(int reviewId, String post, int salary, String position, int pentionScheme, int benefits, int management, int workEnvironment, int flexibility) {
        this.reviewId = reviewId;
        this.post = post;
        this.salary = salary;
        this.position = position;
        this.pensionScheme = pentionScheme;
        this.benefits = benefits;
        this.management = management;
        this.workEnvironment = workEnvironment;
        this.flexibility = flexibility;
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

    public int getPentionScheme() {
        return pensionScheme;
    }

    public void setPentionScheme(int pentionScheme) {
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
}
