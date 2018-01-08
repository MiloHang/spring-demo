package com.hss.myspring.v1.service;

import com.hss.myspring.v1.bean.dao.UserDao;


public class UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(String name) {
		userDao.save(name);
	}
}
