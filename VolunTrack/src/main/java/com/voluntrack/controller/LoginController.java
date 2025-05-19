package com.voluntrack.controller;

import java.io.IOException;

import com.voluntrack.model.UserModel;
import com.voluntrack.service.LoginService;
import com.voluntrack.util.RedirectUtil;
import com.voluntrack.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RedirectUtil redirectionUtil;
    private final LoginService loginService;

    // Controller routes instead of JSP paths
    private static final String LOGIN_PAGE = "/login";
    private static final String HOME_PAGE = "/index"; // Changed from /home to /index
    private static final String ADMIN_PAGE = "/dashboard";

    public LoginController() {
        this.redirectionUtil = new RedirectUtil();
        this.loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward to login.jsp view
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("full_name");
        String password = req.getParameter("password");

        System.out.println("Login attempt - Full Name: [" + fullName + "], Password: [" + password + "]");

        // Validate inputs
        if (ValidationUtil.isNullOrEmpty(fullName) || ValidationUtil.isNullOrEmpty(password)) {
            System.out.println("Validation failed: Redirecting to login");
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!", LOGIN_PAGE);
            return;
        }

        // Admin logic
        if ("admin".equalsIgnoreCase(fullName) && "adminpassword".equals(password)) {
            System.out.println("Admin login successful!");
            req.getSession().setAttribute("full_name", fullName);
            redirectionUtil.setMsgAndRedirect(req, resp, "success", "Welcome Admin!", ADMIN_PAGE);
            return;
        }

        // Regular user login
        UserModel userModel = new UserModel();
        userModel.setFullName(fullName);
        userModel.setPassword(password);

        Boolean isValid = loginService.loginUser(userModel);

        if (isValid == null) {
            System.out.println("Database error");
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Database error, please try again later!", LOGIN_PAGE);
        } else if (isValid) {
            System.out.println("User login successful");
            req.getSession().setAttribute("full_name", fullName);
            redirectionUtil.setMsgAndRedirect(req, resp, "success", "Successfully Logged In!", HOME_PAGE); // This now redirects to /index
        } else {
            System.out.println("Invalid credentials");
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Either full name or password is incorrect!", LOGIN_PAGE);
        }
    }
}