package com.voluntrack.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.voluntrack.config.DbConfig;
import com.voluntrack.model.UserModel;

/**
 * RegisterService handles the registration of new users (volunteers).
 * It manages database interactions for user registration.
 */
public class RegisterService {

    private Connection dbConn;

    /**
     * Constructor initializes the database connection.
     */
    public RegisterService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Registers a new user (volunteer) in the database.
     *
     * @param userModel the user details to be registered
     * @return Boolean indicating success (true/false) or null if DB error
     */
    public Boolean addUser(UserModel userModel) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return null;
        }

        String insertQuery = "INSERT INTO users (full_name, email, phone, location, age, gender, interest_area, password, registration_date) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {
            
            insertStmt.setString(1, userModel.getFullName());
            insertStmt.setString(2, userModel.getEmail());
            insertStmt.setString(3, userModel.getPhone());
            insertStmt.setString(4, userModel.getLocation());
            insertStmt.setInt(5, userModel.getAge());
            insertStmt.setString(6, userModel.getGender());
            insertStmt.setString(7, userModel.getInterestArea());
            insertStmt.setString(8, userModel.getPassword());
            insertStmt.setTimestamp(9, userModel.getRegistrationDate());

            return insertStmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error during user registration: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
