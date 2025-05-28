<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="examModule.moduleModle" %>

<%
String id = (String) request.getAttribute("id");
String moduleName = (String) request.getAttribute("moduleName");
String moduleNum = (String) request.getAttribute("moduleNum");
String timeDiuration = (String) request.getAttribute("timeDiuration");
String picture = (String) request.getAttribute("picture");

if (id == null) id = "";
if (moduleName == null) moduleName = "";
if (moduleNum == null) moduleNum = "";
if (timeDiuration == null) timeDiuration = "";
if (picture == null) picture = "";
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Module</title>
    <link rel="stylesheet" href="updateModule.css"/>
</head>
<body>
<script>
  // Get current page filename from URL path
  const path = window.location.pathname; // e.g. "/onlineExamManagement/moduleUpdate.jsp"
  const fileName = path.substring(path.lastIndexOf('/') + 1); // "moduleUpdate.jsp"

  if (fileName === "moduleUpdate.jsp") {
    const urlParams = new URLSearchParams(window.location.search);

    const id = urlParams.get('id');
    const moduleName = urlParams.get('moduleName');
    const moduleNum = urlParams.get('moduleNum');
    const timeDiuration = urlParams.get('timeDiuration');
    const picture = urlParams.get('picture');

    // Build URL to redirect
    const url = "http://localhost:8090/onlineExamManagement/moduleUpdateServlet?id=" + id + "&moduleName=" + moduleName + "&moduleNum=" + moduleNum + "&timeDiuration=" + timeDiuration + "&picture=" + picture;

    // Redirect to moduleUpdateServlet with parameters
    window.location.href = url;
  }
</script>

<div class="update">

<div class="form-container">
    <h2>Update Module</h2>
    <form action="moduleUpdateServlet" method="POST" enctype="multipart/form-data">
	    <input type="hidden" name="id" value="<%= id %>">
	
	    <div class="form-group">
	        <label>Module Name</label>
	        <input type="text" name="moduleName" value="<%= moduleName %>" >
	    </div>
	
	    <div class="form-group">
	        <label>Module Number</label>
	        <input type="text" name="moduleNum" value="<%= moduleNum %>" >
	    </div>
	
	    <div class="form-group">
	        <label>Time Duration</label>
	        <input type="text" name="timeDiuration" value="<%= timeDiuration %>" >
	    </div>
	
	    <div class="form-group">
	        <label>Current Picture</label><br>
	        <img src="<%= picture %>" alt="Module Picture" style="max-width:200px;">
	    </div>
	
	    <div class="form-group">
	        <label>Upload New Picture (optional)</label>
	        <input type="file" name="picture" accept="image/*">
	    </div>
	
	    <div class="form-group">
	        <input type="submit" value="Update Module">
	    </div>
</form>

</div>


</div>
</body>
</html>

