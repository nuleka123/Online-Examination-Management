<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Profile</title>
	<link rel="stylesheet" href="FeedbackDisplay.css">
	<link rel="stylesheet" href="FeedbackDisplay.css">
	
</head>
<body>

	<center><h1>Profile</h1></center>

	<c:if test="${not empty user}">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Username</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.phone}</td>
					<td>${user.email}</td>
					<td>${user.userName}</td>
					<td>${user.password}
					<a href="/onlineExamManagement/UpdateProfile.jsp?Id=${user.id}&Name=${user.name}&phone=${user.phone}&email=${user.email}&userName=${user.userName}&password=${user.password}">
	  					<button>Update</button>
					</a>  

					<form method="POST" action="/onlineExamManagement/AccountDeleteServlet" style="display:inline;">
							<input type="hidden" name="id" value="${user.id}" />
							<button type="submit" onclick="return confirm('Are you sure you want to delete your account?');">Delete</button>
					</form>
					</td>		
				</tr>
			</tbody>
		</table>
	</c:if>

	<c:if test="${empty user}">
		<p>No user data found. Please log in.</p>
	</c:if>
</body>
</html>
