package com.voluntrack.model;

public class RoleModel {

    //  Fields (Role Properties)
    private int id;
    private String roleName;
    private String description;

    //  Constructors 

    // Default constructor
    public RoleModel() {
    }

    // Constructor with all fields
    public RoleModel(int id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    // Constructor without ID 
    public RoleModel(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    //  Getters & Setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
