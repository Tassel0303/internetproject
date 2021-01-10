package com.entity;


public class Friend {
	
	private int id;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String qq;
	private String job;
	private String location;
	private String postcode;
	
	
	//id,name,sex,phone,email,qq,job,location,postcode
	
	
	
	public Friend(int id, String name, String sex,String phone, String email, String qq, String job, String location,String postcode) {
		super();
		this.id = id;
		
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.qq=qq;
		this.job=job;
		this.location=location;
		this.postcode=postcode;
	}


	//User.java
	public Friend(String name, String sex,String phone, String email, String qq, String job, String location,String postcode) {
		super();
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.qq=qq;
		this.job=job;
		this.location=location;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getQQ() {
		return qq;
	}
	public void setQQ(String qq) {
		this.qq = qq;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	
}
