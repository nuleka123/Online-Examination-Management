<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="Feedback.css">
 
</head>
<body>

   <header>
        <div class="header-container">
            <h3 class="logo">MIKUSO EXAM</h3>
            <div class="icon">
                <img src="iconcover.png" alt="Home Icon">
            </div>
            <nav>
                <ul class="nav-links">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Exam</a></li>
                    <li><a href="#">Result</a></li>
                    <li><a href="Feedback.jsp">Feedback</a></li>
                    <li class="login-btn"><a href="Register.jsp">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>
	<%

	String Id=request.getParameter("Id");
	String Name=request.getParameter("Name");
	String Email=request.getParameter("Email");
	String Subject=request.getParameter("Subject");
	String Message=request.getParameter("Message");
	
	%>
	
 <main>
        <div class="container">
        <form class="feedback-form" action="FeedbackUpdateServlet" method="post">
        
                <h2>Feedback </h2>
				   <label for="name">Id:</label>
                <input type="text"  placeholder="Id" name="Id"  value="<%=Id%>" readonly>
                
                <label for="name">Name:</label>
                <input type="text"  placeholder="Enter Name"  name="Name" value="<%=Name%>" required>

                <label for="email">Email:</label>
                <input type="email"  placeholder="Enter Email"   name="Email" value="<%=Email%>" required>

                <label for="subject">Subject:</label>
                <input type="text"  placeholder="Enter Subject"  name="Subject" value="<%=Subject%>" required>

                <label for="message">Message:</label>
                <textarea  rows="5" placeholder="Enter Message"  name="Message" value="<%=Message%>" required></textarea>

                <button type="submit">Submit</button>
            </form>
        </div>
    </main>

</body>
</html>