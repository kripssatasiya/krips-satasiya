package com.tech.blog.entities;

public class Category {

	private int cid;
	private String name;
	private String description;
	
	
	public Category(int cid, String name, String description) {
		super();
		this.cid = cid;
		this.name = name;
		this.description = description;
	}


	public Category() {
		super();
	}


	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	
	

	// getters and setters

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}
