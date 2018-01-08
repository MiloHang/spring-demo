package com.hss.constructor.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryUtil {
	private static BeanFactory factory = null;
	
	private BeanFactoryUtil(){}
	
	public static BeanFactory getBeanFactory() {
		if(factory == null) {
			factory = new XmlBeanFactory(new ClassPathResource("/com/hss/constructor/beans.xml"));
		}
		return factory;
	}
}
