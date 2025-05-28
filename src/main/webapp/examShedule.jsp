<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Online Exam Modules</title>
  <link rel="stylesheet" href="exams.css" />
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

    <div class="content">
    	<h1 class="exam-mod-title">Exam Modules</h1>
    	
    	<a href="/onlineExamManagement/insertCard.jsp"><button class="create-module">Create new Module</button></a>
  
    <div class="container">

        <div class="fcards">

            <c:forEach var="module" items= "${allmodules}">
            
                <div class="card">
                    <div class="cardinside">
                        <img src="${module.picture}" alt="Module Image" />
                        <h3>${module.moduleName}</h3>
                        <p>${module.moduleNum}</p>
                        <p>${module.timeDiuration}</p>
                        <div class="btn-cont">
                        <a href="moduleUpdateServlet?id=${module.id}&moduleName=${module.moduleName}&moduleNum=${module.moduleNum}&timeDiuration=${module.timeDiuration}&picture=${module.picture}" >
                            <button class="btn">Update</button>
                        </a>
                        
                        <form action="moduleDeleteServlet" method= "post">
                            <input type="hidden" name="id" value="${module.id}" />
                            <button class="btn">Delete</button>
                        </form>
                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
  
        <div class="fcards">

        </div>
    </div>
    </div>

    <footer class="footer">
            <div class="footerL">
                <p>0774154233</p>
                <p>135,sevanagala,embilipitiya</p>
            </div>
            <div class="footerR">
                <p class="footerP">exmaple@gmail.com</p>
                <p class="footerP">exam management</p>
                <p class="footerP">exams</p>
                <a href="https://chatgpt.com/">resourses</a>
            </div>
    </footer>

</body>
</html>
