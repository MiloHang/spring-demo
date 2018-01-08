package com.hss.annotation.dao.impl;


import org.springframework.stereotype.Component;

import com.hss.annotation.dao.UserDao;
import com.hss.annotation.entity.User;

@Component
public class UserDaoImpl2 implements UserDao {
	
	@Override
	public void addUser(User user) {
		System.out.println("UserDaoImpl2 " + user.getName() + " " + user.getAge());
	}
}
