package com.hss.myspring.v1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 当某注解只有一个value属性时，这个value可以省略
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyBean {
	// 注解的返回类型: 基本类型、类类型、字符串、枚举，或者它们的数组
	String value() default "";
}
