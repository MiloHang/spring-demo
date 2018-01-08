package com.hss.myspring.v1;

import org.junit.Test;

import com.hss.myspring.v1.bean.dao.PersonDao;
import com.hss.myspring.v1.bean.dao.impl.PersonDaoImpl;
import com.hss.myspring.v1.container.MyApplicationContext;
import com.hss.myspring.v1.container.MyClassPathXmlApplicationContext;
import com.hss.myspring.v1.service.PersonService;
import com.hss.myspring.v1.service.UserService;

public class Main {
	
	@Test
	public void test1() {
		MyClassPathXmlApplicationContext atx = new MyClassPathXmlApplicationContext("beans2.xml");
		UserService myUserService = (UserService)atx.getBean("myUserService");
		myUserService.save("milo");
	}
	
	@Test
	public void test2() {
		MyApplicationContext atx = new MyApplicationContext();
		PersonService service = (PersonService)atx.getBean("personService");
		System.out.println(service);
		
		PersonDao personDao = atx.getBean(PersonDaoImpl.class);
		System.out.println(personDao);
		
		PersonService service2 = atx.getBean(PersonService.class);
		System.out.println(service2);
		
		service.test("张三");
		service2.test("李四");
	}
}
