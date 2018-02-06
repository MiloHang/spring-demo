package com.hss.aop.aspect.service;

import org.springframework.stereotype.Service;

import com.hss.aop.aspect.annotation.Speaker;

@Service
public class UserService {
	
	public boolean sayHello() {
		System.out.println("Hello World");
		return true;
	}
	
	public void divideZero() {
		// 通过this的调用就不会出现sayHello()的任何通知，this不涉足代理
		this.sayHello();
		try {
			int a = 1/0;
		} catch (Exception e) {
			throw new RuntimeException("除0操作");
		}
	}
	
	@Speaker("admin")
	public boolean sayMessage(String message, String to) {
		System.out.println(message + " to " + to);
		return true;
	}
}
