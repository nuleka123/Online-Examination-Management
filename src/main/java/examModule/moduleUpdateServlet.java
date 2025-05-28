package examModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/moduleUpdateServlet")
@MultipartConfig
public class moduleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get params from URL query string
	    String id = request.getParameter("id");
	    String moduleName = request.getParameter("moduleName");
	    String moduleNum = request.getParameter("moduleNum");
	    String timeDiuration = request.getParameter("timeDiuration");
	    String picture = request.getParameter("picture");

	    // Set params as request attributes to pass them to JSP
	    request.setAttribute("id", id);
	    request.setAttribute("moduleName", moduleName);
	    request.setAttribute("moduleNum", moduleNum);
	    request.setAttribute("timeDiuration", timeDiuration);
	    request.setAttribute("picture", picture);

	    // Forward to JSP page to display form
	    request.getRequestDispatcher("moduleUpdate.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = getValueFromPart(request.getPart("id"));
		String moduleName = getValueFromPart(request.getPart("moduleName"));
		String moduleNum = getValueFromPart(request.getPart("moduleNum"));
		String timeDiuration = getValueFromPart(request.getPart("timeDiuration"));

	    Part filePart = request.getPart("picture");

	    // Fetch existing module from DB
	    List<moduleModle> existingModuleList = modelController.getById(id);
	    System.out.println(existingModuleList);
	    if (existingModuleList == null || existingModuleList.isEmpty()) {
	        request.getRequestDispatcher("wrong.jsp").forward(request, response);
	        return;
	    }
	    moduleModle existingModule = existingModuleList.get(0);

	    boolean shouldUpdateModuleName = !moduleName.equals(existingModule.getModuleName());
	    boolean shouldUpdateModuleNum = !moduleNum.equals(existingModule.getModuleNum());
	    boolean shouldUpdateTimeDiuration = !timeDiuration.equals(existingModule.getTimeDiuration());

	    // For image path update
	    String uploadPath = "C:/Users/USER/Desktop/oop/onlineExamManagement/src/main/webapp/exam_images";
	    String relativeImagePath = existingModule.getPicture(); 
	    boolean shouldUpdateImage = false;

	    if (filePart != null && filePart.getSize() > 0) {
	        String originalFileName = getFileName(filePart);
	        String fileExtension = "";

	        int dotIndex = originalFileName.lastIndexOf('.');
	        if (dotIndex > 0) {
	            fileExtension = originalFileName.substring(dotIndex);
	        }

	        String uniqueFileName = "img_" + System.currentTimeMillis() + fileExtension;
	        java.io.File uploadDir = new java.io.File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }

	        java.io.File newFile = new java.io.File(uploadDir, uniqueFileName);

	        // Save file only if it doesn't exist already
	        if (!newFile.exists()) {
	            filePart.write(newFile.getAbsolutePath());
	            relativeImagePath = "exam_images/" + uniqueFileName;
	            shouldUpdateImage = true;
	        }
	    }

	    if (shouldUpdateModuleName || shouldUpdateModuleNum || shouldUpdateTimeDiuration || shouldUpdateImage) {
	        boolean isTrue = modelController.updatedata(
	            id,
	            shouldUpdateModuleName ? moduleName : existingModule.getModuleName(),
	            shouldUpdateModuleNum ? moduleNum : existingModule.getModuleNum(),
	            shouldUpdateTimeDiuration ? timeDiuration : existingModule.getTimeDiuration(),
	            shouldUpdateImage ? relativeImagePath : existingModule.getPicture() // pass path string, not bytes
	        );

	        if (isTrue) {
	            response.getWriter().println("<script>alert('Data update successful'); window.location.href='getAllservlet';</script>");
	            return;
	        }
	    }

	    request.setAttribute("message", "No changes detected or update failed");
	    request.getRequestDispatcher("wrong.jsp").forward(request, response);
	}

	// You can reuse this utility from insertServlet:
	private String getFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] tokens = contentDisp.split(";");
	    for (String token : tokens) {
	        if (token.trim().startsWith("filename")) {
	            return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return "";
	}
	
	private String getValueFromPart(Part part) throws IOException {
	    if (part == null) return null;
	    try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(part.getInputStream(), "UTF-8"))) {
	        StringBuilder value = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            value.append(line);
	        }
	        return value.toString();
	    }
	}



}