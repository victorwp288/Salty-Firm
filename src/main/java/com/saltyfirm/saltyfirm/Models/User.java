package com.saltyfirm.saltyfirm.Models;

import java.util.Date;

public class User {

    private int userId;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int phoneNumber;
    private String gender;
    private Date birthdate;
    private String education;
    private String mail;
    private String nationality;
    private String privileges;

    public User(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthdate = birthdate;
        this.education = education;
        this.mail = mail;
        this.nationality = nationality;
        this.privileges = privileges;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
}
