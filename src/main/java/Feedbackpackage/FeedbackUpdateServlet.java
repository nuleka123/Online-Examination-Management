package Feedbackpackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackUpdateServlet")
public class  FeedbackUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id=request.getParameter("Id");
		String Name=request.getParameter("Name");
		String  Email=request.getParameter("Email");
		String Subject=request.getParameter("Subject");
		String Message=request.getParameter("Message");
		
		boolean isTrue;
		
		isTrue=FeedbackController.updatedata(Id, Name, Email, Subject, Message);
		
		if(isTrue==true) {
			List<FeedbackModel> FeedDetail=FeedbackController.getById(Id);
			request.setAttribute("FeedDetail",FeedDetail);
			
			String alertMessage="Data update Successs";
			response.getWriter().println("<script>alert('Data insert succesfull!'); window.location.href='FeedGetAllServlet';</script>");

		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);

		
		}
		
	}

}
