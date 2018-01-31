package com.hss.annotation.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hss.annotation.entity.User;
import com.hss.annotation.service.UserService;

@Component
public class UserController {
	
	@Resource(name="userServiceImpl2")
	private UserService userService;
	
	public void addUser(User user) {
		userService.addUser(user);
	}
}
