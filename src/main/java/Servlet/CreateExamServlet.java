package Servlet;

import Model.Exam;
import Services.ExamService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@WebServlet(name = "CreateExamServlet", value = "/createExam")
public class CreateExamServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("createExam.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        String examType = request.getParameter("examType");
        String subject = request.getParameter("subject");
        String semester = request.getParameter("semester");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String examHall = request.getParameter("hall");
        String instructions = request.getParameter("instructions");

        // Validate inputs
        if (examType == null || examType.isEmpty() || examType.length() > 50) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Exam type must be less than 50 characters.");
            response.sendRedirect("createExam");
            return;
        }

        if (subject == null || subject.isEmpty() || subject.length() > 50) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Subject must be less than 50 characters.");
            response.sendRedirect("createExam");
            return;
        }

        if (semester == null || semester.isEmpty() || semester.length() > 50) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Semester must be less than 50 characters.");
            response.sendRedirect("createExam");
            return;
        }

        if (date == null || date.isEmpty()) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Date must be selected.");
            response.sendRedirect("createExam");
            return;
        }

        if (time == null || time.isEmpty()) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Time must be selected.");
            response.sendRedirect("createExam");
            return;
        }

        if (examHall == null || examHall.isEmpty() || examHall.length() > 50) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Exam hall must be less than 50 characters.");
            response.sendRedirect("createExam");
            return;
        }

        if (instructions == null || instructions.isEmpty() || instructions.length() > 500) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Instructions must be less than 500 characters.");
            response.sendRedirect("createExam");
            return;
        }

        // Validate date
        Date sqlDate;
        try {
            sqlDate = Date.valueOf(date);
            if (sqlDate.before(Date.valueOf(LocalDate.now())) || sqlDate.equals(Date.valueOf(LocalDate.now()))) {
                session.setAttribute("status", "failed");
                session.setAttribute("validation", "Exam date must be in the future.");
                response.sendRedirect("createExam");
                return;
            }
        } catch (IllegalArgumentException e) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Invalid date format.");
            response.sendRedirect("createExam");
            return;
        }

        // Validate and format time
        String formattedTime = time;
        if (time.matches("\\d{2}:\\d{2}")) {
            formattedTime = time + ":00"; // Convert "HH:mm" to "HH:mm:ss"
        } else if (!time.matches("\\d{2}:\\d{2}:\\d{2}")) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Invalid time format. Use HH:mm or HH:mm:ss.");
            response.sendRedirect("createExam");
            return;
        }

        ExamService examService = new ExamService();
        Exam exam = new Exam();

        exam.setExamType(examType);
        exam.setSubject(subject);
        exam.setSemester(semester);
        exam.setDate(sqlDate);
        exam.setTime(Time.valueOf(formattedTime));
        exam.setExamHall(examHall);
        exam.setInstructions(instructions);

        boolean isCreated = examService.createExam(exam);

        if (isCreated) {
            session.setAttribute("status", "success");
            session.setAttribute("validation", "Exam created successfully.");
        } else {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Failed to create exam.");
        }

        response.sendRedirect("exams");
    }
}