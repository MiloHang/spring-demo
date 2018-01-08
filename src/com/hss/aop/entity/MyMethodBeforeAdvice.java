package com.hss.aop.entity;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知：方法执行前要执行的代码
 * @author 60512
 *
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	/**
	 * @param method 被代理的方法
	 * @param args method的参数
	 * @pararm target 被代理的对象（目标对象）
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("前置通知开始");
		System.out.println("日志记录:" + new Date());
		System.out.println("被代理的对象：" + target.getClass() + ":" + target);
		System.out.println("执行的方法:" + method.getName());
		System.out.println("方法参数:");
		int paramCount = method.getParameterCount();
		Parameter[] params  =method.getParameters();
		for (int i = 0; i < paramCount; i ++) {
			System.out.printf("%s, %s",params[i].getClass(), args[i].toString());
		}
		System.out.println("\n前置通知结束");
	}
}
