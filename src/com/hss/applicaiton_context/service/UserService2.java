package com.hss.applicaiton_context.service;

public class UserService2 {
	private String name;
	private int age;
	
	private UserService userService;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void show() {
		System.out.println(this.getName() + ' ' + this.getAge());
	}
	
	public void sayHello() {
		System.out.println(this.getName() +" say hello to "+ userService.getName());
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
