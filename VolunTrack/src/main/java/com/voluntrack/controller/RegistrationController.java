package com.voluntrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.voluntrack.model.UserModel;
import com.voluntrack.service.RegisterService;
import com.voluntrack.util.PasswordUtil;

/**
 * RegistrationController handles user registration requests and processes form
 * submissions.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Extract UserModel
            UserModel userModel = extractUserModel(req);
            Boolean isAdded = registerService.addUser(userModel);

            if (isAdded != null && isAdded) {
                req.setAttribute("successMessage", "Your account is successfully created!");
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Could not register your account. Please try again later!");
                req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging purposes
            req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
        }
    }

    // Extract UserModel from form data
    private UserModel extractUserModel(HttpServletRequest req) throws Exception {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String location = req.getParameter("location");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String interestArea = req.getParameter("interest");
        String password = PasswordUtil.encrypt(username, req.getParameter("password"));
        Timestamp registrationDate = Timestamp.valueOf(LocalDateTime.now());

        return new UserModel(fullName, username, email, phone, location, age, gender, interestArea, password, registrationDate);
    }
}
