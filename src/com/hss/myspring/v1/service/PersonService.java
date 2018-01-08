package com.hss.myspring.v1.service;

import com.hss.myspring.v1.annotation.MyBean;
import com.hss.myspring.v1.annotation.MyResource;
import com.hss.myspring.v1.bean.dao.PersonDao;


/**
 * 注解本身不启任何作用，它之所以能起作用是因为后台有解析器
 * */
@MyBean
public class PersonService {

	/** 查找方式：先按名称查找，再按类型查找 */
	@MyResource
	private PersonDao personDao;
	
	public void test(String name) {
		personDao.save(name);
	}
}
