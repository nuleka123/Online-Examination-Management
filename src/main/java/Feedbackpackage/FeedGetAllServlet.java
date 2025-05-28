package Feedbackpackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedGetAllServlet")
public class FeedGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
List <FeedbackModel> allFeeds=FeedbackController.getAllFeed();
		
		request.setAttribute("allFeeds", allFeeds);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("FeedbackDisplay.jsp");
		
		dispatcher.forward(request,response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request,response);

}

}
