<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.12.1/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <title>ExamManagement</title>
</head>

<body>

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5 pt-3">
    <div class="row my-3">
        <div class="col-md-12 d-flex justify-content-between">
            <h4>Exams</h4>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 mb-3">
            <div class="card">
                <div class="card-header">
                    <span><i class="bi bi-table me-2"></i></span> Scheduled Exams Table
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-striped data-table" style="width: 100%">
                            <thead>
                            <tr>
                                <th>Exam Id</th>
                                <th>Exam Type</th>
                                <th>Subject</th>
                                <th>Semester</th>
                                <th>Exam Date</th>
                                <th>Exam Time</th>
                                <th>Exam Hall</th>
                                <th>Instructions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="exam" items="${exams}">
                                <tr>
                                    <td>${exam.examId}</td>
                                    <td>${exam.examType}</td>
                                    <td>${exam.subject}</td>
                                    <td>${exam.semester}</td>
                                    <td><fmt:formatDate value="${exam.date}" pattern="MMM dd, yyyy"/></td>
                                    <td><fmt:formatDate value="${exam.time}" pattern="hh:mm a"/></td>
                                    <td>${exam.examHall}</td>
                                    <td>${exam.instructions}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Exam Id</th>
                                <th>Exam Type</th>
                                <th>Subject</th>
                                <th>Semester</th>
                                <th>Exam Date</th>
                                <th>Exam Time</th>
                                <th>Exam Hall</th>
                                <th>Instructions</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

<jsp:include page="includes/alert.jsp"/>
</body>

</html>