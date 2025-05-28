<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Module Form</title>
  
  <link rel="stylesheet" href="Homepage.css">
  <link rel="stylesheet" href="insertCard.css">
</head>
<body>

<header>
        <div class="header-container">
            <a href="/onlineExamManagement/Homepage.jsp"><h3 class="logo">MIKUSO EXAM</h3></a>
            <div class="icon">
                <img src="iconcover.png" alt="Home Icon">
            </div>
            <nav>
                <ul class="nav-links">
                    <li><a href="Homepage.jsp">Home</a></li>
                    <li><a href="#">Exam</a></li>
                    <li><a href="#">Result</a></li>
                    <li><a href="Feedback.jsp">Feedback</a></li>
                    <li class="login-btn"><a href="Register.jsp">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>


  <div class="main-cont">
  <div class="form-container">
    <h2>Add Module</h2>
    <form action="insertServlet" method="POST" enctype="multipart/form-data">
      <div class="form-group">
        <label for="modulename">Module Name</label>
        <input type="text"  name="moduleName" required>
      </div>
      <div class="form-group">
        <label for="modulenum">Module Number</label>
        <input type="text"  name="moduleNum" required>
      </div>
      <div class="form-group">
        <label for="duration">Time Duration</label>
        <input type="text"  name="timeDiuration" required>
      </div>
      <div class="form-group">
        <label for="picture">Upload Picture</label>
        <input type="file"  name="picture" accept="image/*">
      </div>
      <div class="form-group">
        <input type="submit" value="Add Module">
      </div>
    </form>
  </div>
  </div>
</body>
</html>
