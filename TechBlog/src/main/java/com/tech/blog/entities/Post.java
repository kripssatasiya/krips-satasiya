package com.tech.blog.entities;

import java.sql.Timestamp;



public class Post {

	private int pid;
	private String pTitle;
	private String pContent;
	private String pCode;
	private String pPic;
	private Timestamp pDate;
	private int catID;
	private int userId;
	
	
	public Post(int pid, String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, int catID, int userId) {
		super();
		this.pid = pid;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.pDate = pDate;
		this.catID = catID;
		this.userId = userId;
	}
	
	
	public Post() {
		super();
	}


	public Post(String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, int catID, int userId) {
		super();
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.pDate = pDate;
		this.catID = catID;
		this.userId = userId;

	}

	
 

	// getters and setters 
	
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getpTitle() {
		return pTitle;
	}


	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}


	public String getpContent() {
		return pContent;
	}


	public void setpContent(String pContent) {
		this.pContent = pContent;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getpPic() {
		return pPic;
	}


	public void setpPic(String pPic) {
		this.pPic = pPic;
	}


	public Timestamp getpDate() {
		return pDate;
	}


	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}


	public int getCatID() {
		return catID;
	}


	public void setCatID(int catID) {
		this.catID = catID;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
