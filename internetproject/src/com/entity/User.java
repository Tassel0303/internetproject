package com.entity;

import java.util.Date;

public class User {
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String postcode;
	
	
	public User(){}
	
	public User(int id, String name, String password, String email, String phone, String postcode) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone=phone;
		this.postcode=postcode;
	}



	public User(String name, String password, String email,  String phone, String postcode) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone=phone;
		this.postcode=postcode;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}	
	
}
