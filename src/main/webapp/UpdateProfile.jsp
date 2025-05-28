<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <link rel="stylesheet" href="Feedback.css">
    <link rel="stylesheet" href="ProfileUpdate.css">
</head>
<body>


<div class="modal" id="registerModal">
    <div class="modal-content">
        <span class="close" id="closeModal">&times;</span>
        
        <h2>Update Profile</h2>
        
        <form class="register-form" method="POST" action="/onlineExamManagement/UpdateProfileServlet">
            <label>ID:</label>
            <input type="text" name="id" />

            <label>Full Name:</label>
            <input type="text" name="name" />

            <label>Phone number:</label>
            <input type="text" name="phone" />

            <label>Email:</label>
            <input type="email" name="email"  />

            <label>Username:</label>
            <input type="text" name="userName"   />

            <label>Password:</label>
            <input type="password" name="password"" />

            <button type="submit">Update</button>
        </form>
    </div>
</div>

<script>
    window.addEventListener("DOMContentLoaded", () => {
        const urlParams = new URLSearchParams(window.location.search);

        document.querySelector('input[name="id"]').value = urlParams.get("Id") || "";
        document.querySelector('input[name="name"]').value = urlParams.get("Name") || "";
        document.querySelector('input[name="phone"]').value = urlParams.get("phone") || "";
        document.querySelector('input[name="email"]').value = urlParams.get("email") || "";
        document.querySelector('input[name="userName"]').value = urlParams.get("userName") || "";
        document.querySelector('input[name="password"]').value = urlParams.get("password") || "";
    });
</script>


</body>
</html>
