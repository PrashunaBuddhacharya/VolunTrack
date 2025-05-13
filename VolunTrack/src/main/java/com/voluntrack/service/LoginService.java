""package com.voluntrack.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.voluntrack.model.UserModel;
import com.voluntrack.config.DbConfig;
import com.voluntrack.util.PasswordUtil;

public class LoginService {

    /**
     * Authenticates a user based on full name and password.
     *
     * @param userModel UserModel containing login credentials
     * @return true if login is successful, false otherwise; null if error
     */
    public Boolean loginUser(UserModel userModel) throws ClassNotFoundException {
        String sql = "SELECT full_name, password FROM users WHERE full_name = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userModel.getFullName());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String dbFullName = rs.getString("full_name");
                    String dbPassword = rs.getString("password");

                    // Decrypt the password
                    String decryptedPassword = PasswordUtil.decrypt(dbPassword, dbFullName);

                    System.out.println("DB Full Name: " + dbFullName);
                    System.out.println("Input Full Name: " + userModel.getFullName());
                    System.out.println("DB Password (decrypted): " + decryptedPassword);
                    System.out.println("Input Password: " + userModel.getPassword());

                    return dbFullName.equals(userModel.getFullName()) &&
                           decryptedPassword != null &&
                           decryptedPassword.equals(userModel.getPassword());
                } else {
                    System.out.println("User not found: " + userModel.getFullName());
                    return false;
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
""
