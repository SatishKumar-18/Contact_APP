package com.entity;

public class Contact {
	private int id = (int)(Math.random() * 9000);
	private String name;
	private String email;
	private String phone;
	private int userId;
	
	public Contact() {
		super();
	}
	public Contact(String name, String email, String phone, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
