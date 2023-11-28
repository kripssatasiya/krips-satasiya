package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 */
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.setContentType("text/html"); 
 		try (PrintWriter out =	response.getWriter()) {
 				//login
 			//fetch user name and password
 			String userEmail= request.getParameter("email");
 			String userPassword = request.getParameter("password");
 			
 			UserDao dao = new UserDao(ConnectionProvider.getConnection());
 			
 			User u = dao.getUserByEmailAndPassword(userEmail, userPassword); 
  		 
 			if(u==null) {
 				 // login error
 				Message msg = new Message("Invalid Details ! Try with another.", "error" , "alert-danger");
 				
 				HttpSession s = request.getSession() ;
 				s.setAttribute("msg", msg);
 				
 				response.sendRedirect("login_page.jsp");
 			}
 			
 			else {
 				
 				// login success
 				
 				HttpSession s = request.getSession();
 				s.setAttribute("currentUser", u);
 				
 				response.sendRedirect("profile.jsp");
 				
 				
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
