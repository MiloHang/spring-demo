package com.hss.inherit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.inherit.utils.ApplicationContextUtil;
import com.hss.inherit.entity.Graduate;
import com.hss.inherit.entity.Student;

public class Main {
	
	/**
	 * 继承bean
	 */
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Student stu = (Student)ac.getBean("student");
		Graduate graduate1 = (Graduate)ac.getBean("graduate1");
		
		System.out.println(stu.getAge() + " " + stu.getName());
		System.out.println(graduate1.getAge() + " " + graduate1.getName() + " " + graduate1.getDegree());
	}
	
	/**
	 * 继承bean的配置可被覆盖
	 */
	@Test
	public void test2() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Student stu = (Student)ac.getBean("student");
		Graduate graduate2 = (Graduate)ac.getBean("graduate2");
		
		System.out.println(stu.getAge() + " " + stu.getName());
		System.out.println(graduate2.getAge() + " " + graduate2.getName() + " " + graduate2.getDegree());
	}
}
