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
    <title>MIKUSO EXAMS</title>
</head>

<body>

<jsp:include page="includes/navbar.jsp"/>

<jsp:include page="includes/sidebar.jsp"/>

<main class="mt-5 pt-3">

    <div class="container-fluid">
        <div class="row my-3">
            <div class="col-md-12 d-flex justify-content-between">
                <h4>Exams</h4>

                <a href="createExam" class="btn btn-primary"><i class="bi bi-clipboard-plus-fill"></i> Schedule a New
                    Exam</a>
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
                                    <th>Actions</th>
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
                                        <td>
                                            <a href="updateExam?examId=${exam.examId}"
                                               class="btn btn-primary btn-sm me-2">Update</a>

                                            <!-- Button trigger delete modal -->
                                            <button onclick="openDeleteModal(${exam.examId});" type="button"
                                                    class="btn btn-danger btn-sm mt-2" data-bs-toggle="modal"
                                                    data-bs-target="#deleteModal">
                                                Delete
                                            </button>
                                        </td>
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
                                    <th>Actions</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</main>

<!-- Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Exam</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <p>Are you sure you want to delete this exam?</p>
                <p class="text-primary">Exam ID: <span id="examIdSpan"></span></p>
                <p class="text-danger">Note: This action cannot be undone.</p>
            </div>

            <form action="deleteExam" method="post">

                <input id="examId" type="hidden" name="examId"/>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>

            </form>
        </div>
    </div>
</div>

<script>

    // Delete modal functionality
    function openDeleteModal(examId) {
        // Set the stockId value in the hidden input
        document.getElementById('examId').value = examId;
        document.getElementById('examIdSpan').innerHTML = examId;
    }
</script>

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

<jsp:include page="includes/alert.jsp"/>
</body>

</html>