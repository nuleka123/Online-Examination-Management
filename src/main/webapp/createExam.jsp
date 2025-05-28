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

<jsp:include page="includes/sidebar.jsp"/>

<main class="mt-5 pt-3">

    <div class="container-fluid">
        <div class="row my-3">
            <div class="col-md-12 d-flex justify-content-between">
                <h4>Schedule a New Exam</h4>

                <a href="exams" class="btn btn-primary">Back to Exams</a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 mb-3">
                <div class="card">
                    <div class="card-header">
                        <span><i class="bi bi-plus-circle"></i></span> Schedule a Exam
                    </div>
                    <div class="card-body">

                        <form action="createExam" method="post">

                            <div class="mb-3">
                                <label for="examType" class="form-label">Exam Type</label>

                                <select class="form-select" id="examType" name="examType" required>

                                    <option value="" selected disabled>Select Exam Type</option>
                                    <option value="Midterm">Midterm</option>
                                    <option value="Final">Final</option>
                                    <option value="Quiz">Quiz</option>
                                    <option value="Practical">Practical</option>

                                </select>
                            </div>

                            <div class="mb-3">
                                <label for="subject" class="form-label">Subject</label>
                                <input type="text" name="subject" class="form-control" id="subject" required>
                            </div>

                            <div class="mb-3">
                                <label for="semester" class="form-label">Semester</label>

                                <select class="form-select" id="semester" name="semester" required>

                                    <option value="" selected disabled>Select Semester</option>
                                    <option value="1st">1st Semester</option>
                                    <option value="2nd">2nd Semester</option>
                                    <option value="3rd">3rd Semester</option>
                                    <option value="4th">4th Semester</option>
                                    <option value="5th">5th Semester</option>
                                    <option value="6th">6th Semester</option>
                                    <option value="7th">7th Semester</option>
                                    <option value="8th">8th Semester</option>

                                </select>
                            </div>

                            <div class="mb-3">
                                <label for="date" class="form-label">Exam Date</label>
                                <input type="date" name="date" class="form-control" id="date" required>
                            </div>

                            <div class="mb-3">
                                <label for="time" class="form-label">Exam Time</label>
                                <input type="time" name="time" class="form-control" id="time" required>
                            </div>

                            <div class="mb-3">
                                <label for="hall" class="form-label">Exam Hall</label>
                                <input type="text" name="hall" class="form-control" id="hall" required>
                            </div>

                            <div class="mb-3">
                                <label for="instructions" class="form-label">Instructions</label>
                                <textarea class="form-control" rows="5" id="instructions" name="instructions"
                                          required></textarea>
                            </div>

                            <button type="submit" class="btn btn-primary">Schedule</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>

    </div>

</main>

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

<jsp:include page="includes/alert.jsp"/>
</body>

</html>