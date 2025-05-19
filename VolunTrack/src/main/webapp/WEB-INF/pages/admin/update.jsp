<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User Information</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/update.css" />
</head>
<body>

<div class="container">
<h1>Update User Information</h1>

<!-- Display error message if present -->
<c:if test="${not empty error}">
    <div style="color: red; margin-bottom: 10px;">${error}</div>
</c:if>

<div class="search-bar">
    <form onsubmit="return false;">
        <input type="text" id="searchInput" placeholder="Search by Name or Email" onkeyup="searchTable()">
        <button type="submit" class="btn search-btn">Search</button>
    </form>
    <button class="btn add-btn" onclick="openModal('addModal')">Add User</button>
</div>

<table id="userTable">
    <thead>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Location</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Interest Area</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.fullName}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.location}</td>
                <td>${user.age}</td>
                <td>${user.gender}</td>
                <td>${user.interestArea}</td>
                <td>
                    <button class="btn edit-btn" onclick="openEditModal(${user.id}, '${user.fullName}', '${user.username}', '${user.email}', '${user.phone}', '${user.location}', ${user.age}, '${user.gender}', '${user.interestArea}')">Edit</button>
                    <form action="${pageContext.request.contextPath}/admin/users/delete" method="POST" style="display:inline;" onsubmit="return confirmDelete()">
                        <input type="hidden" name="userId" value="${user.id}">
                        <button type="submit" class="btn delete-btn">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>

<!-- Add User Modal -->
<div id="addModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('addModal')">×</span>
        <h2>Add User</h2>
        <form action="${pageContext.request.contextPath}/admin/users/add" method="POST">
            <input type="text" name="fullName" placeholder="Full Name" value="${user.fullName}" required>
            <input type="text" name="username" placeholder="Username" value="${user.username}" required>
            <input type="email" name="email" placeholder="Email" value="${user.email}" required>
            <input type="text" name="phone" placeholder="Phone" value="${user.phone}">
            <input type="text" name="location" placeholder="Location" value="${user.location}">
            <input type="number" name="age" placeholder="Age" value="${user.age > 0 ? user.age : ''}">
            <input type="text" name="gender" placeholder="Gender" value="${user.gender}">
            <input type="text" name="interestArea" placeholder="Interest Area" value="${user.interestArea}">
            <button type="submit">Add User</button>
        </form>
    </div>
</div>

<!-- Edit User Modal -->
<div id="editModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('editModal')">×</span>
        <h2>Edit User</h2>
        <form action="${pageContext.request.contextPath}/admin/users/edit" method="POST">
            <input type="hidden" name="userId" id="editUserId" value="${user.id}">
            <input type="text" name="fullName" id="editFullName" placeholder="Full Name" value="${user.fullName}" required>
            <input type="text" name="username" id="editUsername" placeholder="Username" value="${user.username}" required>
            <input type="email" name="email" id="editEmail" placeholder="Email" value="${user.email}" required>
            <input type="text" name="phone" id="editPhone" placeholder="Phone" value="${user.phone}">
            <input type="text" name="location" id="editLocation" placeholder="Location" value="${user.location}">
            <input type="number" name="age" id="editAge" placeholder="Age" value="${user.age > 0 ? user.age : ''}">
            <input type="text" name="gender" id="editGender" placeholder="Gender" value="${user.gender}">
            <input type="text" name="interestArea" id="editInterestArea" placeholder="Interest Area" value="${user.interestArea}">
            <button type="submit">Update User</button>
        </form>
    </div>
</div>

<script>
    function openModal(modalId) {
        document.getElementById(modalId).style.display = 'block';
    }

    function closeModal(modalId) {
        document.getElementById(modalId).style.display = 'none';
    }

    function openEditModal(id, fullName, username, email, phone, location, age, gender, interestArea) {
        document.getElementById('editUserId').value = id;
        document.getElementById('editFullName').value = fullName;
        document.getElementById('editUsername').value = username;
        document.getElementById('editEmail').value = email;
        document.getElementById('editPhone').value = phone;
        document.getElementById('editLocation').value = location;
        document.getElementById('editAge').value = age;
        document.getElementById('editGender').value = gender;
        document.getElementById('editInterestArea').value = interestArea;
        openModal('editModal');
    }

    function confirmDelete() {
        return confirm('Are you sure you want to delete this user?');
    }

    // Search functionality
    function searchTable() {
        let input = document.getElementById('searchInput').value.toLowerCase();
        let table = document.getElementById('userTable');
        let rows = table.getElementsByTagName('tbody')[0].getElementsByTagName('tr');

        for (let i = 0; i < rows.length; i++) {
            let fullName = rows[i].getElementsByTagName('td')[1].textContent.toLowerCase();
            let email = rows[i].getElementsByTagName('td')[3].textContent.toLowerCase();
            if (fullName.includes(input) || email.includes(input)) {
                rows[i].style.display = '';
            } else {
                rows[i].style.display = 'none';
            }
        }
    }

    // Close modal when clicking outside
    window.onclick = function(event) {
        if (event.target.classList.contains('modal')) {
            closeModal('addModal');
            closeModal('editModal');
        }
    }

    // Auto-open add/edit modal on failure with session data
    <c:if test="${not empty user}">
        <c:choose>
            <c:when test="${user.id > 0}">
                openEditModal(${user.id}, '${user.fullName}', '${user.username}', '${user.email}', '${user.phone}', '${user.location}', ${user.age}, '${user.gender}', '${user.interestArea}');
            </c:when>
            <c:otherwise>
                openModal('addModal');
            </c:otherwise>
        </c:choose>
    </c:if>
</script>

</body>
</html>