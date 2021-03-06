package com.hss.aop.entity;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * 我的环绕通知连接点
 * @author Shaoshi Hang
 *
 */
public class MyAroundAdvice implements MethodInterceptor {

	/**
	 * @param invocation 方法委托对象
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕通知开始");
		Object obj = invocation.getThis();
		System.out.println(obj);
		// proceed()方法很重要，一定要要调用才能真正执行被代理对象内部的方法。
		Object returnVal = invocation.proceed();
		System.out.println("环绕通知结束");
		
		String s = (String)returnVal;
		s += " 被拦截处理过";
		// 方法体的return结果 要在该拦截处返回,也意味着返回结果可以被处理
		return (Object)s;
	}
}
