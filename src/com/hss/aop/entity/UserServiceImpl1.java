package com.hss.aop.entity;

import java.util.HashMap;

public class UserServiceImpl1 implements UserService1, UserService2 {
	
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
	
	public void divideZero() {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			throw new RuntimeException("方法体代码执行异常");
		}
	}
}
