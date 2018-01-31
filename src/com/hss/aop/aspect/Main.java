package com.hss.aop.aspect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.aop.aspect.service.UserService;
import com.hss.aop.utils.ApplicationContextUtil2;

public class Main {	
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil2.getApplicationContext();
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
}
