package com.hss.aop.aspect.annotation;

import org.springframework.stereotype.Service;

@Service("userComponent")
public class UserComponent {
	public void sayYes() {
		System.out.println("yes");
	}
}
