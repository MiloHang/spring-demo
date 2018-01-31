package com.hss.aop.aspect.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.hss.aop.aspect.annotation.Speaker;

@Service
public class UserService {
	
	public boolean sayHello() {
		System.out.println("Hello World");
		return true;
	}
	
	public void divideZero() {
		try {
			int a = 1/0;
		} catch (Exception e) {
			throw new RuntimeException("除0操作");
		}
	}
	
	@Speaker("hss")
	public boolean sayMessage(String message, String to) {
		System.out.println(message + " to " + to);
		return true;
	}
}
