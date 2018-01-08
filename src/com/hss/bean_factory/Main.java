package com.hss.bean_factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import com.hss.applicaiton_context.service.User;
import com.hss.applicaiton_context.service.UserService;
import com.hss.applicaiton_context.test.ApplicationContextUtil;

public class Main {
	
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext(); // 对象会自动装配，消耗内存，效率高
	}
	
	@Test
	public void test2() {
		BeanFactory beanFactory = BeanFactoryUtil.getBeanFactory(); // bean不会自动装配，省空间
	}
	
	@Test
	public void test3() {
		BeanFactory beanFactory = BeanFactoryUtil.getBeanFactory();
		UserService service =  (UserService)beanFactory.getBean("userService"); // get时才会装配
		System.out.println(service.getName());
		
	}
	
	/**
	 * bean的scope测试
	 */
	@Test
	public void test4() {
		BeanFactory beanFactory = BeanFactoryUtil.getBeanFactory();
		User u1 = (User)beanFactory.getBean("default"); // 默认是singleton
		User u2 = (User)beanFactory.getBean("default");
		User u3 = (User)beanFactory.getBean("singleton");
		User u4 = (User)beanFactory.getBean("singleton");
		User u5 = (User)beanFactory.getBean("prototype");
		User u6 = (User)beanFactory.getBean("prototype");
		
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());
		System.out.println(u3.hashCode());
		System.out.println(u4.hashCode());
		System.out.println(u5.hashCode());
		System.out.println(u6.hashCode());
		
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		User u11 = (User)beanFactory.getBean("default"); // 默认是singleton
		User u22 = (User)beanFactory.getBean("default");
		User u33 = (User)beanFactory.getBean("singleton");
		User u44 = (User)beanFactory.getBean("singleton");
		User u55 = (User)beanFactory.getBean("prototype");
		User u66 = (User)beanFactory.getBean("prototype");
		
		System.out.println(u11.hashCode());
		System.out.println(u22.hashCode());
		System.out.println(u33.hashCode());
		System.out.println(u44.hashCode());
		System.out.println(u55.hashCode());
		System.out.println(u66.hashCode());
	}
}
