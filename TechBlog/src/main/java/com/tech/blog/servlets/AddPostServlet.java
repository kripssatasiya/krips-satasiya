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
import java.sql.Timestamp;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class AddPostServlet
 */

@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		response.setContentType("text/html"); 
// 		try (PrintWriter out =	response.getWriter()) {
//
// 			 String cidParam = request.getParameter("cid");
// 	        if (cidParam != null && !cidParam.isEmpty()) {
// 	            try {
// 	                int cid1 = Integer.parseInt(cidParam);
// 	                // Rest of your code here...
//
// 	                // Use the 'cid' variable as needed in your code
// 	            } catch (NumberFormatException e) {
// 	                // Handle the case when the 'cid' parameter is not a valid integer
// 	                out.println("Invalid 'cid' parameter. Please provide a valid integer value.");
// 	            }
// 	        } else {
// 	            // Handle the case when the 'cid' parameter is null or empty
// 	            out.println("'cid' parameter is missing or empty. Please provide a valid integer value.");
// 	        }
// 			
// 			
// 			int cid = Integer.parseInt(request.getParameter("cid1"));
// 			String pTitle = request.getParameter("pTitle");
// 			String pContent = request.getParameter("pContent");
// 			String pCode = request.getParameter("pCode");
// 			Part part = request.getPart("pic");
// 			
// 			 // getting current user id
// 			HttpSession session = request.getSession();
// 			User user =(User)session.getAttribute("currentUser"); 
// 			
// 			out.println(" your post title is "+pTitle);
// 			out.println(part.getSubmittedFileName());
// 			
// 			Post p = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid, user.getId());
// 			
// 			PostDao dao = new PostDao(ConnectionProvider.getConnection());
// 			if(dao.savePost(p)) {
// 			   String pathh = request.getServletContext().getRealPath("/")+"blog_pics"+File.separator + part.getSubmittedFileName();
// 			   Helper.saveFile(part.getInputStream(), pathh);
//				out.println("done");
//
// 				
// 			}
// 			else {
// 				out.println("error");
//
// 			}
// 		}
// 	} 
//    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {

            String cidParam = request.getParameter("cid");
            if (cidParam != null && !cidParam.isEmpty()) {
                try {
                    int cid = Integer.parseInt(cidParam);
                    String pTitle = request.getParameter("pTitle");
                    String pContent = request.getParameter("pContent");
                    String pCode = request.getParameter("pCode");
                    Part part = request.getPart("pic");

                    // Getting the current user id
                    HttpSession session = request.getSession();
                    User user = (User) session.getAttribute("currentUser");

                    // out.println("Your post title is " + pTitle);
                    // out.println(part.getSubmittedFileName());

                    Post p = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid, user.getId());

                    PostDao dao = new PostDao(ConnectionProvider.getConnection());
                    if (dao.savePost(p)) {
                        String pathh = request.getServletContext().getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
                        Helper.saveFile(part.getInputStream(), pathh);
                        out.println("Done");

                    } else {
                        out.println("Error");

                    }
                } catch (NumberFormatException e) {
                    // Handle the case when the 'cid' parameter is not a valid integer
                    out.println("'cid' parameter is not a valid integer. Please provide a valid integer value.");
                }
            } else {
                // Handle the case when the 'cid' parameter is null or empty
                out.println("'cid' parameter is missing or empty. Please provide a valid integer value.");
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
