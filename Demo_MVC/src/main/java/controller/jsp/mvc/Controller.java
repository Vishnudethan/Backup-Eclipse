package controller.jsp.mvc;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig // this is given to receive the submitted file
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String action=request.getParameter("action");
    	UserService us=new UserServImpl();
    	HttpSession session =request.getSession();
    	if(action.equals("insert")) {
    		UserModel um =new UserModel();
    		um.setUserName(request.getParameter("userName"));
    		um.setUserEmail(request.getParameter("userEmail"));
    		um.setUserAge(Integer.parseInt(request.getParameter("userAge")));
    		um.setFileLocation(getServletContext().getRealPath("Files"));
    		um.setFile(request.getPart("userFile"));
    		 LocalDateTime currentDateTime = LocalDateTime.now();
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	         // Format and print
	         String formattedDateTime = currentDateTime.format(formatter);
	         um.setDate(formattedDateTime);
    		String result=us.insertUser(um);
    		if(result.equals("success")) {
    			response.sendRedirect("Register.jsp");
    		}
    	}
    	if(action.equals("view")) {
    		List<UserModel> list= us.ViewUser();
    		session.setAttribute("userList", list);
    		System.out.println(list);
    		response.sendRedirect("View.jsp");
    	}
    	if(action.equals("viewone")){
    		Integer id=Integer.parseInt(request.getParameter("userId"));
    		UserModel um=us.viewOneUser(id);
    		 session.setAttribute("updateUser", um); 
    		response.sendRedirect("Update.jsp");
    	}
    	if(action.equals("update")) {
    		UserModel um =new UserModel();
    		um.setId(Integer.parseInt(request.getParameter("userId")));
    		um.setUserName(request.getParameter("userName"));
    		
    		um.setUserEmail(request.getParameter("userEmail"));
    		um.setUserAge(Integer.parseInt(request.getParameter("userAge")));
    		um.setFileLocation(getServletContext().getRealPath("Files"));
    		Part str=request.getPart("userFile");
    		//System.out.println("username :"+str.);
    		um.setFile(request.getPart("userFile"));
    		String result=us.updateUser(um);
    		if(result.equals("success")) {
    			List<UserModel> list= us.ViewUser();
        		session.setAttribute("userList", list);
        		request.getRequestDispatcher("View.jsp").forward(request, response);
        		
    		}
    		else {
    	        // This part is missing in your code!
    			//System.out.println("Resu : "+result);
    	        request.setAttribute("message", "Update failed. Please try again.");
    	        request.getRequestDispatcher("Update.jsp").forward(request, response);
    	    }
    	
    		
    	}
    		if(action.equals("delete")) {
    			UserModel um=new UserModel();
    			um.setId(Integer.parseInt(request.getParameter("userId")));
    			um.setFileLocation(getServletContext().getRealPath("Files"));
    			String result=us.deleteUser(um);
    			if(result.equals("success")) {
    				List<UserModel> list=us.ViewUser();
    				session.setAttribute("userList", list);
    				response.sendRedirect("View.jsp");
    			}
    		}
    	
       
    }
}
