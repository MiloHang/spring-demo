package com.hss.aop.aspect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.aop.aspect.annotation.UserComponent;
import com.hss.aop.aspect.service.PersonService;
import com.hss.aop.aspect.service.UserService;
import com.hss.aop.utils.ApplicationContextUtil2;

public class Main {	
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
		// 这里拿到的service是CGLIB的代理对象
		UserService service = ac.getBean(UserService.class);
		if(service.sayHello()) {
			System.out.println("true");
		}
	}
	
	@Test
	public void test2() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
		UserService service = ac.getBean(UserService.class);
		
		service.divideZero();
	}
	
	@Test
	public void test3() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
		UserService service = ac.getBean(UserService.class);
		service.sayMessage("hi", "tom");
	}
	
	@Test
	public void test4() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
		UserComponent component = (UserComponent)ac.getBean(UserComponent.class);
	}
	
	@Test
	public void test5() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
		// 这里拿到的personService是JDK动态代理的代理对象
		PersonService personService = (PersonService)ac.getBean(PersonService.class);
		personService.sayHello();
	}
	
	@Test
	public void test6() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
		// 这里拿到的personService是JDK动态代理的代理对象
		PersonService personService = (PersonService)ac.getBean(PersonService.class);
		personService.plainMethod();
	}
}
