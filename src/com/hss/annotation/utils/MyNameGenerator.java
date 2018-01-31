package com.hss.annotation.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

public class MyNameGenerator implements BeanNameGenerator {

	@Override
	public String generateBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		String className = definition.getBeanClassName();
		String[] names = className.split("\\.");
		String beanName = names[names.length - 1];
		char[] beanNameChr = beanName.toCharArray();
		beanNameChr[0] += 32; 
		beanName = new String(beanNameChr);
		return beanName + "generator";
	}

}
