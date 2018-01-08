package com.hss.bean_lifecycle;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Demo3Service implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	
	private String name;

	public Demo3Service() {
		System.out.println("Demo3Service无参构造函数被调用...");
	}
	
	public Demo3Service(String name) {
		System.out.println("Demo3Service有参构造函数被调用...");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Demo3Service设置属性...");
		this.name = name;
	}
	
	/**
	 * 获得Bean id：<bean id="bean1" class="..."/>
	 */
	public void setBeanName(String arg0) {
		// arg0 = "bean1"
		System.out.println("setBeanName被调用:id为 " + arg0);
	}

	/**
	 * 获得Bean工厂
	 */
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("设置BeanFactory" + " " + beanFactory);
	}

	/**
	 * 获得应用上下文
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("设置ApplicationContext" + " " + applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()方法执行...");
	}
	
	
	
	public void myInit() {
		System.out.println("定制的初始化方法执行...");
	}

	/**
	 * DisaposibleBean的destroy方法()
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("容器要关闭了....销毁bean，及资源释放...");
		FileOutputStream fout = new FileOutputStream("../../../demo3.txt");
		fout.write("bean被销毁了".getBytes());
		fout.close();
	}
	
	public void myDestroy() throws Exception {
		System.out.println("容器要关闭了....自定义方法销毁bean，及资源释放...");
	} 
}
