package com.hss.autowire.entity;

import org.springframework.beans.factory.BeanNameAware;

public class Dog implements BeanNameAware {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setBeanName(String name) {
		
		System.out.println("setBeanName()" + name);
	}
	
	
}
