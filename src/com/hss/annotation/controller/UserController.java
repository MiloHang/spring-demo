package com.hss.annotation.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hss.annotation.entity.User;
import com.hss.annotation.service.UserService;

@Component
public class UserController {
	
	// Resource注解可以指定要注入的bean的名字
	//@Resource(name="userServiceImpl2")
	
	//Autowire注解根据类型注入，有多个bean是同一类型的时候可以使用@Qulifier注解指定某一个bean
	@Autowired
	@Qualifier("userServiceImpl2")
	private UserService userService;
	
	public void addUser(User user) {
		userService.addUser(user);
	}
}
