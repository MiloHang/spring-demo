package com.hss.annotation;



import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.hss.annotation.controller.UserController;
import com.hss.annotation.entity.User;
import com.hss.annotation.utils.ApplicationContextUtil;

public class Main {
	
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		UserController controller = (UserController)ac.getBean(UserController.class);
		User user = new User();
		user.setAge(18);
		user.setName("Milo");
		controller.addUser(user);
	}
}
