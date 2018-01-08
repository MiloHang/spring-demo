package com.hss.specialbean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.specialbean.entity.DataSource;
import com.hss.specialbean.utils.*;;

public class Main {
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		DataSource source = (DataSource)ac.getBean("dataSource1");
		System.out.println(source.toString());
	}
	
	@Test
	public void test2() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		DataSource source = (DataSource)ac.getBean("dataSource2");
		System.out.println(source.toString());
	}
}
