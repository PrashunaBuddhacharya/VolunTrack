package com.voluntrack.model;

import java.sql.Timestamp;

public class User_Opportunity_ViewModel {

    // Fields (Properties) 
    private int id;                 // Unique view record ID
    private int userId;            // ID of the user who viewed
    private int opportunityId;     // ID of the opportunity viewed
    private Timestamp viewTime;    // When the view happened

    //  Constructors 

    // Default constructor
    public User_Opportunity_ViewModel() {
    }

    // Full constructor with ID 
    public User_Opportunity_ViewModel(int id, int userId, int opportunityId, Timestamp viewTime) {
        this.id = id;
        this.userId = userId;
        this.opportunityId = opportunityId;
        this.viewTime = viewTime;
    }

    // Constructor without ID 
    public User_Opportunity_ViewModel(int userId, int opportunityId, Timestamp viewTime) {
        this.userId = userId;
        this.opportunityId = opportunityId;
        this.viewTime = viewTime;
    }

    //  Getters & Setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(int opportunityId) {
        this.opportunityId = opportunityId;
    }

    public Timestamp getViewTime() {
        return viewTime;
    }

    public void setViewTime(Timestamp viewTime) {
        this.viewTime = viewTime;
    }
}
