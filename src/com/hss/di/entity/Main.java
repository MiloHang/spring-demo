package com.hss.di.entity;

import org.junit.Test;

public class Main {
	
	public <T> T getObj(Object t) {
		
		return (T)t;
	}
	
	@Test
	public void test() {
		Object p = getObj(new Object());
		System.out.println(p);
	}
}
