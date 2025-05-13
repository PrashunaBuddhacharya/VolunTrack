<!DOCTYPE html>
<html>
<head>
    <title>Update User Record</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/update.css" />
</head>
<body>

<div class="container">
    <h2>Update User Information</h2>
    
    <form action="UpdateController" method="post">
        <div class="form-group">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" readonly value="${userId}">
        </div>
        
        <div class="form-group">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" value="${fullName}" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${email}" required>
        </div>

        <div class="form-group">
            <label for="role">Role:</label>
            <input type="text" id="role" name="role" value="${role}" required>
        </div>

        <button type="submit">Update User</button>
    </form>
</div>

</body>
</html>
