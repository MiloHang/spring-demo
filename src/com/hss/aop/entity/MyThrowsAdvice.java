package com.hss.aop.entity;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("这里进行统一的异常处理工作: ");
		System.out.println("异常信息为: " + ex.getMessage());
	}
}
