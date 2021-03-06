package com.hss.specialbean.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  因为ApplicationContext是spring中重量级的对象，作为单例存在于内存中更好
 *  避免多次实例化浪费内存
 *  
 *  单例模式特点：
 *  	1.静态私有成员变量
 *  	2.私有构造函数
 *  	3.静态公共访问方法
 * */
public final class ApplicationContextUtil {
	//懒加载，用时加载，节省资源
	private static ApplicationContext ac = null;
	
	private ApplicationContextUtil() {
		
	}
	
	public static ApplicationContext getApplicationContext() {
		if(ac == null) {
			System.out.println(ApplicationContextUtil.class.getName());
			ac = new ClassPathXmlApplicationContext("/com/hss/specialbean/beans.xml");
		} 
		return ac;
	}
}
