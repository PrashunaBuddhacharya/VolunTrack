""<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - Voluntrack</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/admin/dashboard.css' />">
</head>
<body>

    <!-- Navigation Bar -->
    <div class="navbar">
        <h2>Admin Dashboard - Voluntrack</h2>
    </div>

    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
            <li><a href="<c:url value='/admin/dashboard' />">Dashboard</a></li>
            <li><a href="<c:url value='/admin/opportunities' />">Manage Opportunities</a></li>
            <li><a href="<c:url value='/admin/users' />">Manage Users</a></li>
            <li><a href="<c:url value='/admin/reports' />">Reports</a></li>
            <li><a href="<c:url value='/admin/settings' />">Settings</a></li>
            <li><a href="<c:url value='/logout' />">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="content">
        <h3>Welcome to the Admin Dashboard</h3>

        <!-- Overview Cards -->
        <div class="dashboard-cards">
            <div class="card">
                <h4>Total Opportunities</h4>
                <p>120</p>
            </div>
            <div class="card">
                <h4>Active Volunteers</h4>
                <p>340</p>
            </div>
            <div class="card">
                <h4>Pending Applications</h4>
                <p>15</p>
            </div>
            <div class="card">
                <h4>Upcoming Events</h4>
                <p>5</p>
            </div>
        </div>

        <!-- Detailed Information (Mirroring User Page) -->
        <h3>Opportunities Overview</h3>
        <div class="opportunities-grid">
            <c:forEach var="opportunity" items="${opportunitiesList}">
                <div class="card">
                    <h4>${opportunity.title}</h4>
                    <p>${opportunity.description}</p>
                    <p><strong>Location:</strong> ${opportunity.location}</p>
                    <p><strong>Date:</strong> ${opportunity.date}</p>
                    <p><strong>Status:</strong> ${opportunity.status}</p>
                    <a href="<c:url value='/admin/opportunity/edit?id=${opportunity.id}' />">Edit</a>
                    <a href="<c:url value='/admin/opportunity/delete?id=${opportunity.id}' />">Delete</a>
                </div>
            </c:forEach>
        </div>
    </div>

</body>
</html>
""
