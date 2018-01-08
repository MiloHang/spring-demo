package com.hss.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hss.annotation.entity.User;
import com.hss.annotation.service.UserService;

@Component
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void addUser(User user) {
		userService.addUser(user);
	}
}
