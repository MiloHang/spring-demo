package com.hss.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.aop.entity.User;
import com.hss.aop.entity.UserService1;
import com.hss.aop.entity.UserService2;
import com.hss.aop.entity.UserServiceImpl1;
import com.hss.aop.utils.ApplicationContextUtil;

public class Main {
	/**
	 * 使用原对象不会产生任何作用
	 */
	@Test
	public void test1() {
		User user = new User();
		user.setAge(21);
		user.setName("杭少石");
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		UserService1 service1 = (UserService1)ac.getBean("userService1");
		System.out.println(service1.getUserInfo(user));
	}
	
	/**
	 * 使用代理对象
	 */
	@Test
	public void test2() {
		User user = new User();
		user.setAge(21);
		user.setName("杭少石");
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		
		UserService1 service1 = (UserService1)ac.getBean("proxyFactoryBean");
		System.out.println(service1.getUserInfo(user));
		// 实现了多个接口的类可以转成  实现的任意一个接口
		// 这里相当于执行了
		// ProxyFactoryBean implements UserService1, UserSerice2 {
		//      getUserInfo(){}
		// 		addUser(){}
		// }
		// 转为UserService2接口
		UserService2 service2 = (UserService2)service1;
		service2.addUser(user);
		
		// 获得代理对象执行addUser()方法过后里面的user
		UserServiceImpl1 instanceService  = (UserServiceImpl1)ac.getBean("userService1");
		User user2 = (User)instanceService.getUsers().get(user.getName());
		System.out.println(user2);
	}
	
	@Test
	public void test3() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		UserService1 service1 = (UserService1)ac.getBean("proxyFactoryBean");
		try {
			service1.divideZero();
		} catch(Exception e) {
			
		}
	}
}
