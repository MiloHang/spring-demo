package com.hss.aop.aspect.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import com.hss.aop.aspect.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	public void sayHello() {
		System.out.println("personService sayHello()...");
		// 这里 Set 'exposeProxy' property on Advised to 'true' to make it available
		if(null != AopContext.currentProxy()) {
			
			((PersonService)AopContext.currentProxy()).thisMethod("代理执行");
		} else {
			this.thisMethod("this执行");
		}
	}
	
	public void thisMethod(String message) {
		System.out.println(message);
	}

	@Override
	public void plainMethod() {
		// TODO Auto-generated method stub
		System.out.println("不用代理");
	}
}
