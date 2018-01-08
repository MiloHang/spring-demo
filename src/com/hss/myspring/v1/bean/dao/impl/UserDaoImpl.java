package com.hss.myspring.v1.bean.dao.impl;

import com.hss.myspring.v1.bean.dao.UserDao;


public class UserDaoImpl implements UserDao {

	@Override
	public void save(String name) {
		System.out.println("保存用户：" + name);
	}

}
