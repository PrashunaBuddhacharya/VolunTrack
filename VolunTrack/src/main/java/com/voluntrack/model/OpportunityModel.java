package com.voluntrack.model;

import java.sql.Timestamp;

public class OpportunityModel {

    //  Fields (Opportunity Properties)
    private int id;
    private String title;
    private String description;
    private String organization;
    private String location;         // Could be enhanced to a LocationModel
    private Timestamp startDate;
    private Timestamp endDate;
    private String eligibilityCriteria;
    private String category;
    private String imageUrl;         // URL or path to an image for UI display

    //  Constructors 

    // Default constructor
    public OpportunityModel() {
    }

    // Constructor with all fields except ID 
    public OpportunityModel(String title, String description, String organization, String location,
                            Timestamp startDate, Timestamp endDate, String eligibilityCriteria,
                            String category, String imageUrl) {
        this.title = title;
        this.description = description;
        this.organization = organization;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eligibilityCriteria = eligibilityCriteria;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    // Constructor with all fields including ID 
    public OpportunityModel(int id, String title, String description, String organization, String location,
                            Timestamp startDate, Timestamp endDate, String eligibilityCriteria,
                            String category, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.organization = organization;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eligibilityCriteria = eligibilityCriteria;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    //  Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
