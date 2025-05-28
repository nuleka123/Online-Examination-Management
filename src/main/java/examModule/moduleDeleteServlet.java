package examModule;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/moduleDeleteServlet")
public class moduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isTrue;
		
		isTrue = modelController.deletedata(id);
		
		if(isTrue == true)
		{
			String alertMessage = "Data Delete Succesful";
			response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='getAllservlet';</script>");
		}
		
		else {
			List<moduleModle> moduleDetails = modelController.getById(id);
			request.setAttribute("moduleDetails",moduleDetails);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("wrong.jsp");
			dispacher.forward(request, response);
			
		}
	}

}
