package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.MediaSize.Other;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		try (PrintWriter out =	response.getWriter()) {
			    
				// fetch all form data
				
				String check = request.getParameter("check");
				if(check==null) {
					out.println("box not checked");
				}
				else {
					// to extract the remaining data 
					String name = request.getParameter("user_name"); 
					String email = request.getParameter("user_email"); 
					String password = request.getParameter("user_password"); 
					String gender = request.getParameter("gender"); 
					String about = request.getParameter("about"); 

					
					// create user object and set all data to that object
					User user = new User(name,email,password,gender,about);
					
					
					// create userDao object
					UserDao dao = new UserDao(ConnectionProvider.getConnection());
					if(dao.saveUser(user)){
						//save....
						out.println("done");
					}
					else {
						out.println("error");
					}
				}				
		 
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
