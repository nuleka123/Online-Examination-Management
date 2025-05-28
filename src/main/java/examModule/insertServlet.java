package examModule;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/insertServlet")
@MultipartConfig
public class insertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String moduleName = request.getParameter("moduleName");
        String moduleNum = request.getParameter("moduleNum");
        String timeDiuration = request.getParameter("timeDiuration");

        Part filePart = request.getPart("picture");

        // Extract original file name
        String originalFileName = getFileName(filePart);
        String fileExtension = "";

        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0) {
            fileExtension = originalFileName.substring(dotIndex); // includes dot
        }

        // Generate unique file name
        String uniqueFileName = "img_" + System.currentTimeMillis() + fileExtension;

        // Define the folder path to save uploaded files
        String uploadPath = "C:/Users/USER/Desktop/oop/onlineExamManagement/src/main/webapp/exam_images";

        // Create folder if it doesn't exist
        java.io.File uploadDir = new java.io.File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Full path to save file
        String filePath = uploadPath + java.io.File.separator + uniqueFileName;

        // Save the uploaded file to disk
        filePart.write(filePath);

        // Save relative path (good practice for web apps)
        String relativePath = "exam_images/" + uniqueFileName;

        // Call model to insert data
        boolean isTrue = modelController.insertdata(moduleName, moduleNum, timeDiuration, relativePath);

        if (isTrue) {
            String alertMessage = "Data insert successful";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='getAllservlet';</script>");
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }

    // Utility method to extract file name from part header
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
}
