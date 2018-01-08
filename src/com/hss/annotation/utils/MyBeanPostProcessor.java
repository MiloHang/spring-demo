package com.hss.annotation.utils;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.format.datetime.DateFormatter;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessBeforeInitialization() 被调用... " + "bean: " + bean+ " beanName: " + beanName);
		System.out.println(bean + " 开始实例化..." + "时间为: " + new Date());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessAfterInitialization() 被调用... " +"bean: " + bean + " beanName: " + beanName);
		System.out.println(bean + " 实例化完成..." + "时间为: " + new Date());
		System.out.println("============================================");
		return bean;
	}

}
