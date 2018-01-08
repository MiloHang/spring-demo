package com.hss.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.autowire.entity.Master;
import com.hss.autowire.utils.ApplicationContextUtil;


public class Main {
	
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Master master = (Master)ac.getBean("master1");
		System.out.println(master.getName() + " " + master.getDog().getName());
	}
	
	@Test
	public void test2() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Master master = (Master)ac.getBean("master2");
		System.out.println(master.getName() + " " + master.getDog().getName());
	}
	
	@Test
	public void test3() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Master master = (Master)ac.getBean("master3");
		System.out.println(master.getName() + " " + master.getDog().getName());
	}
}
