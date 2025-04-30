package com.voluntrack.model;

import java.sql.Timestamp;

public class UserModel {

    private int id;
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private String location; // Can be enhanced to LocationModel if joined
    private int age;
    private String gender;
    private String interestArea;
    private String password;
    private Timestamp registrationDate;

    // ======= Constructors =======

    public UserModel() {
        // Default
    }

    // Login purpose
    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Full constructor with ID (e.g., when fetching from DB)
    public UserModel(int id, String fullName, String email, String phone, String location,
                     int age, String gender, String interestArea, String password, Timestamp registrationDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.age = age;
        this.gender = gender;
        this.interestArea = interestArea;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    // Constructor without ID (e.g., during registration)
    public UserModel(String fullName, String email, String phone, String location,
                     int age, String gender, String interestArea, String password, Timestamp registrationDate) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.age = age;
        this.gender = gender;
        this.interestArea = interestArea;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    // Constructor for limited view (e.g., profile list)
    public UserModel(int id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    // ======= Getters & Setters =======

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
