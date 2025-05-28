package Servlet;


import Services.ExamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteExamServlet", value = "/deleteExam")
public class DeleteExamServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        if (request.getParameter("examId") == null || request.getParameter("examId").isEmpty()) {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "No exam selected for update.");
            response.sendRedirect("exams");
            return;
        }

        int examId = Integer.parseInt(request.getParameter("examId"));

        ExamService examService = new ExamService();

        boolean isDeleted = examService.deleteExam(examId);

        if (isDeleted) {
            session.setAttribute("status", "success");
            session.setAttribute("validation", "Exam deleted successfully.");
        } else {
            session.setAttribute("status", "failed");
            session.setAttribute("validation", "Failed to delete exam.");
        }

        response.sendRedirect("exams");
        return;
    }

}