package com.hss.annotation.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hss.annotation.dao.UserDao;
import com.hss.annotation.entity.User;
import com.hss.annotation.service.UserService;

@Service
public class UserServiceImpl2 implements UserService {

	/**
	 * Resource注解：
	 * 1.默认使用字段名作为id，在spring容器中查找相应bean,然后回退为原始UserDao类型注入
	 * 2.指定name属性会查找id=name的bean,然后回退为原始UserDao类型注入
	 */
	@Resource(name="primaryUserDao")
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
}
