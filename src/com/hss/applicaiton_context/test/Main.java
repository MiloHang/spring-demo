package com.hss.applicaiton_context.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hss.applicaiton_context.service.ChangeLetter;
import com.hss.applicaiton_context.service.ChangeToUpper;
import com.hss.applicaiton_context.service.UserService;
import com.hss.applicaiton_context.service.UserService2;

public class Main {
	
	@Test
	//	自身bean注入
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService)context.getBean("userService");
		us.show();
	}
	
	@Test
	//	自身bean注入
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService2 us2 = (UserService2)context.getBean("userService2");
		us2.show();
	}
	
	@Test
	// 引用的bean注入
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService2 us2 = (UserService2)context.getBean("userService2");
		us2.sayHello();
	}
	
	@Test
	// 将ApplicationContext作为单例模式
	public void test4() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		ApplicationContext ac2 = ApplicationContextUtil.getApplicationContext();
		System.out.println(ac == ac2);
		UserService userService = (UserService)ac.getBean("userService");
		userService.show();
	}
	
	@Test
	public void test5() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		//ChangeToUpper toUpper = (ChangeToUpper)ac.getBean("change");
		ChangeLetter changeLetter = (ChangeLetter)ac.getBean("change");
		
		//System.out.println("upper:" + toUpper.change());
		System.out.println(changeLetter.change());
	}

}
