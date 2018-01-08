package com.hss.bean_lifecycle;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;


public class Main {
	/**
	 * ApplicaitonContext的bean生命周期
	 */
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();	
		Demo3Service service = (Demo3Service)ac.getBean("bean1");
		System.out.println(service.getName());
	}
	
	/**
	 * BeanFactory的bean生命周期
	 */
	@Test
	public void test2() {
		BeanFactory factory = BeanFactoryUtil.getBeanFactory();
		factory.getBean("bean2");
	}
}
