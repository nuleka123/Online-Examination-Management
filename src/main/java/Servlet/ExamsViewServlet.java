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
import java.util.ArrayList;

@WebServlet(name = "ExamsViewServlet", value = "/examsView")
public class ExamsViewServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("examsView.jsp");

        HttpSession session = request.getSession();

        ExamService examService = new ExamService();
        ArrayList<Exam> exams = examService.getAllExams();

        request.setAttribute("exams", exams);
        dispatcher.forward(request, response);
    }

}