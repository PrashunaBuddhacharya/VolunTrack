package com.voluntrack.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.voluntrack.model.UserModel;
import com.voluntrack.service.UpdateService;

/**
 * Servlet for handling user CRUD operations.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/update", "/admin/users/*" })
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UpdateService updateService;

    public UpdateController() {
        super();
        this.updateService = new UpdateService();
    }

    /**
     * Handles GET requests to display the user list.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserModel> userList = updateService.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("WEB-INF/pages/admin/update.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for adding, updating, or deleting users.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();
        List<UserModel> userList = updateService.getAllUsers();
        req.setAttribute("userList", userList); // Ensure user list is available

        if (path == null || path.equals("/")) {
            doGet(req, resp);
            return;
        }

        try {
            if (path.equals("/add")) {
                // Create user
                String fullName = req.getParameter("fullName");
                String username = req.getParameter("username");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String location = req.getParameter("location");
                String ageStr = req.getParameter("age");
                String gender = req.getParameter("gender");
                String interestArea = req.getParameter("interestArea");

                UserModel user = new UserModel();
                user.setFullName(fullName);
                user.setUsername(username);
                user.setEmail(email);
                user.setPhone(phone != null && !phone.isEmpty() ? phone : null);
                user.setLocation(location != null && !location.isEmpty() ? location : null);
                user.setAge(ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0);
                user.setGender(gender != null && !gender.isEmpty() ? gender : null);
                user.setInterestArea(interestArea != null && !interestArea.isEmpty() ? interestArea : null);
                user.setPassword(""); // Default empty password (can be adjusted)

                Boolean result = updateService.addUser(user);
                if (result != null && result) {
                    resp.sendRedirect(req.getContextPath() + "/update");
                } else {
                    req.getSession().setAttribute("user", user);
                    handleOperationFailure(req, resp, result, "Add Failed. Please try again!");
                }
            } else if (path.equals("/edit")) {
                // Update user
                int userId = Integer.parseInt(req.getParameter("userId"));
                String fullName = req.getParameter("fullName");
                String username = req.getParameter("username");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String location = req.getParameter("location");
                String ageStr = req.getParameter("age");
                String gender = req.getParameter("gender");
                String interestArea = req.getParameter("interestArea");

                UserModel user = new UserModel();
                user.setId(userId);
                user.setFullName(fullName);
                user.setUsername(username);
                user.setEmail(email);
                user.setPhone(phone != null && !phone.isEmpty() ? phone : null);
                user.setLocation(location != null && !location.isEmpty() ? location : null);
                user.setAge(ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0);
                user.setGender(gender != null && !gender.isEmpty() ? gender : null);
                user.setInterestArea(interestArea != null && !interestArea.isEmpty() ? interestArea : null);
                user.setPassword(""); // Default empty password (can be adjusted)

                Boolean result = updateService.updateUserInfo(user);
                if (result != null && result) {
                    resp.sendRedirect(req.getContextPath() + "/update");
                } else {
                    req.getSession().setAttribute("user", user);
                    handleOperationFailure(req, resp, result, "Update Failed. Please try again!");
                }
            } else if (path.equals("/delete")) {
                // Delete user
                int userId = Integer.parseInt(req.getParameter("userId"));
                Boolean result = updateService.deleteUser(userId);
                if (result != null && result) {
                    resp.sendRedirect(req.getContextPath() + "/update");
                } else {
                    handleOperationFailure(req, resp, result, "Delete Failed. Please try again!");
                }
            } else {
                doGet(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("WEB-INF/pages/admin/update.jsp").forward(req, resp);
        }
    }

    /**
     * Handles operation failures by setting an error message and forwarding to the update page.
     */
    private void handleOperationFailure(HttpServletRequest req, HttpServletResponse resp, Boolean result, String defaultError)
            throws ServletException, IOException {
        String errorMessage = (result == null) ? "Server error. Please try again later!" : defaultError;
        req.setAttribute("error", errorMessage);
        req.getRequestDispatcher("WEB-INF/pages/admin/update.jsp").forward(req, resp);
    }
}