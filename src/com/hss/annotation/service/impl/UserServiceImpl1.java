package com.hss.annotation.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hss.annotation.dao.UserDao;
import com.hss.annotation.entity.User;
import com.hss.annotation.service.UserService;

@Service
public class UserServiceImpl1 implements UserService {

	/**
	 * Autowired默认是byType方式注入 有多个同类型会报错
	 * 譬如： 面向接口编程时，同一接口有多个实现类 : NoneUniqueBean
	 * 解决方法：Autowired方式更改为Resource 默认byName方式
	 */
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
}
