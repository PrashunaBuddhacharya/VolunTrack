package com.voluntrack.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.voluntrack.config.DbConfig;
import com.voluntrack.model.UserModel;

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
     * Updates user information in the database.
     *
     * @param user The UserModel object containing the updated user data.
     * @return Boolean indicating the success of the update operation. Returns null if error.
     */
    public Boolean updateUserInfo(UserModel user) {
        if (isConnectionError) {
            System.out.println("Database connection error!");
            return null;
        }

        String updateSQL = "UPDATE users SET full_name = ?, email = ?, phone = ?, location = ?, age = ?, "
                         + "gender = ?, interest_area = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getLocation());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getInterestArea());
            preparedStatement.setInt(8, user.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
