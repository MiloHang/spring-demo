package com.hss.annotation.dao.impl;


import org.springframework.stereotype.Component;

import com.hss.annotation.dao.UserDao;
import com.hss.annotation.entity.User;

/**
 * <code>@Component</code>默认实例化以类名首字母小写为id的bean
 * <br>
 * <code>@Component(value="primaryUserDao")</code>指定id="primaryUserDao"
 */
@Component
public class UserDaoImpl1 implements UserDao {
	
	@Override
	public void addUser(User user) {
		System.out.println("UserDaoImpl1 " + user.getName() + " " + user.getAge());
	}
}
