package UserPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Feedbackpackage.FeedbackController;

@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String  phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
	boolean isTrue;
		
		isTrue=UserController.insertdata(name, phone, email, userName, password);
		
		if(isTrue==true) {
			String alertMessage="Register Successs";
			
			response.getWriter().println("<script>alert('Data insert succesfull!'); window.location.href='Register.jsp';</script>");

		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);

		
		}
	}

}
