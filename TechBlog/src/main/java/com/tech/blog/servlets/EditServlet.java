package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
 import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class EditServlet
 */

@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setContentType("text/html"); 
  		try 
  		 (PrintWriter out = response.getWriter()){
  			
  			
  			// fetch all data
  			 String userEmail = request.getParameter("user_email"); 
  			 String userPassword = request.getParameter("user_password"); 
  			 String userAbout = request.getParameter("about"); 

  			 Part part = request.getPart("image");
  			 String imageName = part.getSubmittedFileName();
  			 
           // get the user from the session... 		
  			 HttpSession s = request.getSession();
  			 User user = (User)s.getAttribute("currentUser");			
  			 user.setEmail(userEmail);
  			 user.setPassword(userPassword);
  			 user.setAbout(userAbout);
  			 
  			 String oldFile = user.getProfile();
  			 user.setProfile(imageName);
  			 
  		// update database...
  		UserDao userDao = new UserDao(ConnectionProvider.getConnection());  		
  		
  		boolean ans = userDao.updateUser(user);
  		
  		if (ans) {
			
		   String path = request.getServletContext().getRealPath("/")+"profile_pics"+File.separator + user.getProfile();
          
           // delete code
		   String pathOldFile = request.getServletContext().getRealPath("/")+"profile_pics"+File.separator + oldFile;
		   if(!oldFile.equals("default.png")) {
			   Helper.deletFile(pathOldFile);   
		   }
		   
           if(Helper.saveFile(part.getInputStream(), path)){
					out.println("Profile Updated...");
	 				Message msg = new Message("Profile Updated...", "success" , "alert-success");
	 				
	 				s.setAttribute("msg", msg);
			}
			else {
					out.println("not updated");
					Message msg = new Message("Something went wrong...", "error" , "alert-danger");
						
					s.setAttribute("msg", msg);	
			}
		}
  		else {
			out.println("not updated");
			Message msg = new Message("Something went wrong...", "error" , "alert-danger");
				
			s.setAttribute("msg", msg);
		}
  		response.sendRedirect("profile.jsp");
  		}	  
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		processRequest(request, response);
	}

}
