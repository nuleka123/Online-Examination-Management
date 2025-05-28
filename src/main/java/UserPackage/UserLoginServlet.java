package UserPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try {
			List<UserModel> userList = UserController.loginValidate(userName, password);

			if (userList != null && !userList.isEmpty()) {
				// Login successful
				UserModel user = userList.get(0); // Get the first (and only) user

				// Store user in session
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				// Redirect to ProfileServlet to display user profile
				response.sendRedirect("ProfileServlet");
			} else {
				// Login failed
				response.setContentType("text/html");
				response.getWriter().println("<script type='text/javascript'>");
				response.getWriter().println("alert('Invalid credentials, please try again');");
				response.getWriter().println("location='Register.jsp';");
				response.getWriter().println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
