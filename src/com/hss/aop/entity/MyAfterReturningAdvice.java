package com.hss.aop.entity;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知：方法执行前要执行的代码
 * @author 60512
 *
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	/**
	 * @param returnValue 方法的返回值
	 * @param returnValue 方法
	 * @param returnValue 方法参数
	 * @param returnValue 目标对象（被代理的对象）
	 */
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println(method.getName() + "后置通知结束...");
	}
}
