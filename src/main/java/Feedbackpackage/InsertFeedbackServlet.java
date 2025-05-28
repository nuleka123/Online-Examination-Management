package Feedbackpackage;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackServlet")

public class InsertFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name=request.getParameter("Name");
		String  Email=request.getParameter("Email");
		String Subject=request.getParameter("Subject");
		String Message=request.getParameter("Message");
		
		boolean isTrue;
		
		isTrue=FeedbackController.insertdata(Name, Email, Subject, Message);
		
		if(isTrue==true) {
			String alertMessage="Data insert Successs";
			
			response.getWriter().println("<script>alert('Data insert succesfull!'); window.location.href='FeedGetAllServlet';</script>");

		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);

		
		}
	}

}
