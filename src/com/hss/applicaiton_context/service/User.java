package com.hss.applicaiton_context.service;

public class User {
	private String name;
	
	public User() {
		System.out.println("User create..");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
