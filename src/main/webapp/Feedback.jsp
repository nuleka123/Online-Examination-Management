<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback - Online Exam System</title>
    <link rel="stylesheet" href="Feedback.css">
    <link rel="stylesheet" href="Homepage.css">
    
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
                    <li><a href="/onlineExamManagement/getAllservlet">Module</a></li>
                    <li><a href="/onlineExamManagement/exams">Exams</a></li>
                    <li><a href="Feedback.jsp">Feedback</a></li>
                    <li class="login-btn"><a href="Register.jsp">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <div class="container">
        <form class="feedback-form" action="FeedbackServlet" method="post">
        
                <h2>Feedback </h2>

                <label for="name">Name:</label>
                <input type="text"  placeholder="Enter Name" required name="Name">

                <label for="email">Email:</label>
                <input type="email"  placeholder="Enter Email" required  name="Email">

                <label for="subject">Subject:</label>
                <input type="text"  placeholder="Enter Subject" required name="Subject">

                <label for="message">Message:</label>
                <textarea  rows="5" placeholder="Enter Message" required name="Message" ></textarea>

                <button type="submit">Submit</button>
            </form>
        </div>
    </main>

</body>
</html>
