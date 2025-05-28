package UserPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("profile.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        System.out.println(id + " " + name + phone + email + userName + password);

        boolean isTrue = UserController.updateProfile(id, name, phone, email, userName, password);

        if (isTrue) {
            List<UserModel> userDetail = UserController.getById(id);
            request.setAttribute("UserDetail", userDetail);

            response.setContentType("text/html");
            response.getWriter().println("<script>alert('Profile updated successfully!'); window.location.href='profile.jsp';</script>");
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}
