<!-- dashboard.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/dashboard.css" />
    <title>Admin Dashboard - Voluntrack</title>
</head>
<body>
    <div class="sidebar">
        <div class="sidebar-header">
            <h2>Voluntrack</h2>
        </div>
        <ul class="sidebar-menu">
            <li class="active">Dashboard</li>
            <li><a href="${pageContext.request.contextPath}/update">Update</a></li>  
        </ul>
    </div>

    <div class="main-content">
        <div class="header">
            <h1>Admin Dashboard</h1>
            <input type="text" placeholder="Search..." class="search-bar">
        </div>

        <div class="dashboard-container">
            <div class="card blue">
                <h3>Total Users</h3>
                <p id="total-users">500</p>
            </div>
            <div class="card green">
                <h3>Monthly Growth</h3>
                <p id="monthly-growth">20%</p>
            </div>
            <div class="card purple">
                <h3>Top Locations</h3>
                <p id="top-locations">Kathmandu, Pokhara</p>
            </div>
            <div class="card orange">
                <h3>New Registrations</h3>
                <p id="new-registrations">15 this week</p>
            </div>
        </div>

        <div class="chart-container">
            <h2>User Registration Growth</h2>
            <canvas id="user-growth-chart"></canvas>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const ctx = document.getElementById('user-growth-chart').getContext('2d');
        const userGrowthChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May'],
                datasets: [{
                    label: 'Users Registered',
                    data: [30, 45, 60, 80, 100],
                    backgroundColor: '#4f46e5'
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    }
                }
            }
        });
    </script>
</body>
</html>