package com.voluntrack.service;

import com.voluntrack.config.DbConfig;
import com.voluntrack.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for updating user (volunteer) information in the database.
 */
public class UpdateService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Constructor initializes the database connection.
     */
    public UpdateService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Retrieves all users from the database.
     * @return List of UserModel objects.
     */
    public List<UserModel> getAllUsers() {
        List<UserModel> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setLocation(rs.getString("location"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setInterestArea(rs.getString("interest_area"));
                user.setPassword(rs.getString("password"));
                user.setRegistrationDate(rs.getTimestamp("registration_date"));

                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userList;
    }

    /**
     * Adds a new user to the database.
     * @param user The UserModel object containing user data.
     * @return Boolean indicating success (true), invalid data (false), or error (null).
     */
    public Boolean addUser(UserModel user) {
        if (isConnectionError) {
            System.out.println("Database connection error!");
            return null;
        }

        // Basic validation for required fields
        if (user.getFullName() == null || user.getUsername() == null || user.getEmail() == null ||
            user.getFullName().trim().isEmpty() || user.getUsername().trim().isEmpty() || user.getEmail().trim().isEmpty()) {
            return false;
        }

        String insertSQL = "INSERT INTO user (full_name, username, email, phone, location, age, gender, interest_area, password) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = dbConn.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone() != null ? user.getPhone() : null);
            preparedStatement.setString(5, user.getLocation() != null ? user.getLocation() : null);
            preparedStatement.setInt(6, user.getAge() > 0 ? user.getAge() : 0); // 0 for NULL
            preparedStatement.setString(7, user.getGender() != null ? user.getGender() : null);
            preparedStatement.setString(8, user.getInterestArea() != null ? user.getInterestArea() : null);
            preparedStatement.setString(9, user.getPassword() != null ? user.getPassword() : ""); // Default empty if null

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates user information in the database.
     * @param user The UserModel object containing updated user data.
     * @return Boolean indicating success (true), invalid data (false), or error (null).
     */
    public Boolean updateUserInfo(UserModel user) {
        if (isConnectionError) {
            System.out.println("Database connection error!");
            return null;
        }

        // Basic validation for required fields and ID
        if (user.getId() <= 0 || user.getFullName() == null || user.getUsername() == null || user.getEmail() == null ||
            user.getFullName().trim().isEmpty() || user.getUsername().trim().isEmpty() || user.getEmail().trim().isEmpty()) {
            return false;
        }

        String updateSQL = "UPDATE user SET full_name = ?, username = ?, email = ?, phone = ?, location = ?, age = ?, " +
                          "gender = ?, interest_area = ?, password = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone() != null ? user.getPhone() : null);
            preparedStatement.setString(5, user.getLocation() != null ? user.getLocation() : null);
            preparedStatement.setInt(6, user.getAge() > 0 ? user.getAge() : 0); // 0 for NULL
            preparedStatement.setString(7, user.getGender() != null ? user.getGender() : null);
            preparedStatement.setString(8, user.getInterestArea() != null ? user.getInterestArea() : null);
            preparedStatement.setString(9, user.getPassword() != null ? user.getPassword() : ""); // Default empty if null
            preparedStatement.setInt(10, user.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deletes a user from the database by ID.
     * @param userId The ID of the user to delete.
     * @return Boolean indicating success (true), invalid ID (false), or error (null).
     */
    public Boolean deleteUser(int userId) {
        if (isConnectionError) {
            System.out.println("Database connection error!");
            return null;
        }

        if (userId <= 0) {
            return false;
        }

        String deleteSQL = "DELETE FROM user WHERE id = ?";

        try (PreparedStatement preparedStatement = dbConn.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, userId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}