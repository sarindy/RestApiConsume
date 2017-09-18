package com.example;

public class Model {
	private int id;
	private String fullName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Model() {
		
	}
	public Model(int id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}
	
	
	

}
