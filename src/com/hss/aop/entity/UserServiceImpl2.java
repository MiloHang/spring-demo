package com.hss.aop.entity;

import java.util.HashMap;

public class UserServiceImpl2 implements UserService1 {
	
	HashMap<String, User> users = new HashMap<String, User>();
	
	public String getUserInfo(User user) {
		return user.getName() + " " + user.getAge();
	}

	public void addUser(User user) {
		users.put(user.getName(), user);
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}

	@Override
	public void divideZero() {
		
	}
}
