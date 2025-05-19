package com.voluntrack.model;

import java.sql.Timestamp;

public class UserModel {
    private int id;
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private String location;
    private int age;
    private String gender;
    private String interestArea;
    private String password;
    private Timestamp registrationDate;

    // Default constructor
    public UserModel() {
    }

    // Constructor for login (used in login controller)
    public UserModel(String fullName, String password) {
        this.fullName = fullName;
        this.password = password;
    }

    // Full constructor without ID (for registration)
    public UserModel(String fullName, String username, String email, String phone, String location, int age,
                     String gender, String interestArea, String password, Timestamp registrationDate) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.age = age;
        this.gender = gender;
        this.interestArea = interestArea;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterestArea() {
        return interestArea;
    }

    public void setInterestArea(String interestArea) {
        this.interestArea = interestArea;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
}
