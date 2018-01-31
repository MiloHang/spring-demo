package com.hss.propertyeditor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.propertyeditor.entity.School;
import com.hss.propertyeditor.entity.User;
import com.hss.propertyeditor.utils.ApplicationContextUtil;

public class Main {
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		User user = (User)ac.getBean("user");
		School school = (School)ac.getBean("school");
		System.out.println(user);
		System.out.println(school);
	}
}
