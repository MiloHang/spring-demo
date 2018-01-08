package com.hss.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.constructor.entity.Student;
import com.hss.constructor.utils.ApplicationContextUtil;


public class Main {
	
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Student stu = (Student)ac.getBean("student");
		System.out.println(stu.getName() + " " + stu.getAge());
	}
}
