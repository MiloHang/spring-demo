package com.hss.applicaiton_context.service;

public class UserService {
	private String name;
	
	public UserService() {
		System.out.println("UserService被创建");
	}
	public void show() {
		System.out.println(this.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
