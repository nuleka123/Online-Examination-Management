package Feedbackpackage;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FeedbackDeleteServlet")
public class FeedbackDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Id = request.getParameter("Id");
        boolean isTrue;

        if (Id != null && !Id.isEmpty()) {
            isTrue = FeedbackController.deletedata(Id);

            if (isTrue) {
                String alertMessage = "Data deleted successfully.";
                response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='FeedGetAllServlet';</script>");
            } else {
                List<FeedbackModel> FeedDetails = FeedbackController.getById(Id);
                request.setAttribute("FeedDetails", FeedDetails);
                RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.getWriter().println("<script>alert('Invalid ID provided'); window.location.href='FeedGetAllServlet';</script>");
        }
    }
}
