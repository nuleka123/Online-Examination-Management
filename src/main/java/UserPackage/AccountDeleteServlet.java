package UserPackage;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AccountDeleteServlet")
public class AccountDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean isTrue = UserController.deleteAccount(id);

        if (isTrue) {
            String alertMessage = "Account deleted successfully.";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='Register.jsp';</script>");
        } else {
            List<UserModel> userDetails = UserController.getById(id);
            request.setAttribute("UserDetails", userDetails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method not supported");
    }
}
