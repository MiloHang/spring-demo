package com.hss.propertyeditor.entity;

public class School {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		System.out.println("setUser " + user);
		this.user = user;
	}
}
