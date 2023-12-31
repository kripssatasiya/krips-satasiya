package com.tech.blog.dao;

import java.sql.*;

import com.tech.blog.entities.User;

public class UserDao {

	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	// method to insert user to data base :
	
	public boolean saveUser(User user) {
		boolean f = false;
//		try {
//			
//			// user  -----> database
//			
//			String query = "INSERT INTO user(name,email,password,gender,about) VALUES (?,?,?,?,?)";
//			PreparedStatement pstmt = this.con.prepareStatement(query);
//			pstmt.setString(1, user.getName());
//			pstmt.setString(2, user.getEmail());
//			pstmt.setString(3, user.getPassword());
//			pstmt.setString(4, user.getGender());
//			pstmt.setString(5, user.getAbout());
//
//			pstmt.executeUpdate(query);     <<<<<<---------- here is problem because of it gives error here we pass query object;
//			f=true;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
		// Assuming you have a Connection object called 'connection'
		
		  // user -------> database
		String sql = "INSERT INTO user (name, email, password, gender, about) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
		    statement.setString(1, user.getName());
		    statement.setString(2, user.getEmail());
		    statement.setString(3, user.getPassword());
		    statement.setString(4, user.getGender());
		    statement.setString(5, user.getAbout());

		     statement.executeUpdate();
		     f=true;
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return f;
	}

	
	
	
	public boolean updateUser(User user) {
		
		boolean f = false;
		
		String query = "UPDATE user SET email=? , password=?, about=? , profile=? WHERE id = ?"; 

		try (PreparedStatement p = con.prepareStatement(query)){	
		  p.setString(1, user.getEmail());
		  p.setString(2, user.getPassword());
		  p.setString(3, user.getAbout());
		  p.setString(4, user.getProfile());
		  p.setInt(5, user.getId());
		  
		  p.executeUpdate();
		  f= true;
		  
		} 
		catch (Exception e) {
		 e.printStackTrace();	
			
		}
		return f;
	}
	
	
	
	
	
	
	
	// get user by email and password
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;
		try {
			String query ="select * from user where email = ? and password = ?"; 
			PreparedStatement pstmt =con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
					
			ResultSet set = pstmt.executeQuery();
			
			if(set.next()) {
				user=new User();
				
				// data from db
				String name = set.getString("name"); 
				//set to user object
				user.setName(name);
				
				
				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setRdate(set.getTimestamp("rdate"));
				user.setProfile(set.getString("profile"));
				
			}
			else {
			
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

	public User getUserByUserId(int userId) {
		User user= null;
		String q = "select * from user where id=?";
		try(PreparedStatement ps = this.con.prepareStatement(q)) {
			
			ps.setInt(1, userId);
			
			ResultSet set = ps.executeQuery();
			if(set.next()) {
		        user=new User();
				
				// data from db
				String name = set.getString("name"); 
				//set to user object
				user.setName(name);
				
				
				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setRdate(set.getTimestamp("rdate"));
				user.setProfile(set.getString("profile"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
}
