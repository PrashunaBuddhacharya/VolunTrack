package com.voluntrack.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.voluntrack.config.DbConfig;
import com.voluntrack.model.UserModel;
import com.voluntrack.util.PasswordUtil;

public class LoginService {

    private static final String SELECT_USER_SQL =
        "SELECT full_name, password FROM user WHERE full_name = ?";

    /**
     * @param userModel contains fullName + password
     * @return TRUE if login succeeds, FALSE if bad credentials,
     *         null if any database error or missing connection
     */
    public Boolean loginUser(UserModel userModel) {
        if (userModel == null
         || userModel.getFullName() == null
         || userModel.getPassword() == null) {
            return false;
        }

        Connection conn = null;
        try {
            conn = DbConfig.getDbConnection();
            if (conn == null) {
                System.err.println("LoginService: DbConfig.getConnection() returned null");
                return null;
            }

            try (PreparedStatement stmt = conn.prepareStatement(SELECT_USER_SQL)) {
                stmt.setString(1, userModel.getFullName());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (!rs.next()) {
                        return false;  // no such user
                    }
                    String dbEncrypted = rs.getString("password");
                    String dbPassword  = PasswordUtil.decrypt(dbEncrypted, rs.getString("full_name"));
                    return dbPassword != null && dbPassword.equals(userModel.getPassword());
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("LoginService: SQL error during login: " + e.getMessage());
            return null;
        } finally {
            // clean up if DbConfig doesn't close the connection internally
            if (conn != null) {
                try { conn.close(); }
                catch (SQLException ignore) { }
            }
        }
    }
}
