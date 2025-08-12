package controller.connector.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig // this is given to receive the submitted file
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 PrintWriter out = response.getWriter();
    	try {
        String folderLocation = getServletContext().getRealPath("Files");
        Part p = request.getPart("userFile");
       

         System.out.println(folderLocation + "\\" + p.getSubmittedFileName());

        String filename = p.getSubmittedFileName();
        // upload the name, email, age, vishnu@gmail.com.pdf
       // p.write(folderLocation + "\\" + request.getParameter("userEmail")
               // + filename.substring(filename.lastIndexOf('.')));
        p.write(folderLocation + "\\" + filename);
        
        	out.println("File uploaded successfylly");
        
       
    	}
    		catch(Exception e) {
    			out.println("error while upload" +e);
    	}
    	
    	//response.sendRedirect("Register.jsp");;
    	
       
    }
}