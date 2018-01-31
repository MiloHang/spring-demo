package com.hss.aop.entity;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class MyIntroduction implements IntroductionInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnVal = invocation.proceed();
		return returnVal;
	}

	@Override
	public boolean implementsInterface(Class<?> intf) {
		return true;
	}

}
