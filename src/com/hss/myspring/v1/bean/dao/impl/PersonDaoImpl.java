package com.hss.myspring.v1.bean.dao.impl;

import com.hss.myspring.v1.annotation.MyBean;
import com.hss.myspring.v1.bean.dao.PersonDao;

@MyBean("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void save(String name) {
		System.out.println("保存了: " + name);
	}

}
