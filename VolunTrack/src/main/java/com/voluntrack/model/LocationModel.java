package com.voluntrack.model;

/**
 * Represents a location where volunteering opportunities are available.
 */
public class LocationModel {

    //  Fields (Properties) 
    private int id;             // Unique ID of the location
    private String city;        // City name
    private String state;       // State or region
    private String country;     // Country name

    // Constructors

    // Default constructor
    public LocationModel() {
    }

    // Constructor with all fields 
    public LocationModel(int id, String city, String state, String country) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Constructor without ID 
    public LocationModel(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters & Setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
