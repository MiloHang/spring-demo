package com.hss.di;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import com.hss.di.entity.Demo3Service;
import com.hss.di.entity.Department;
import com.hss.di.entity.Person;
import com.hss.di.utils.ApplicationContextUtil;
import com.hss.di.utils.BeanFactoryUtil;

public class Main {
	/**
	 * ApplicaitonContext的bean生命周期
	 */
	@Test
	public void test1() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Demo3Service service = (Demo3Service) ac.getBean("bean1");
		System.out.println(service.getName());
		System.out.println(1 / 0);
	}

	/**
	 * BeanFactory的bean生命周期
	 */
	@Test
	public void test2() {
		BeanFactory factory = BeanFactoryUtil.getBeanFactory();
		factory.getBean("bean2");
	}

	/**
	 * 普通数组的依赖注入
	 */
	@Test
	public void test3() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Department department = (Department) ac.getBean("department1");
		System.out.println(department.getId());

		for (String name : department.getPerson()) {
			System.out.println(name);
		}
	}

	/**
	 * 对象数组的依赖注入
	 */
	@Test
	public void test4() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Department department = (Department) ac.getBean("department2");

		for (Person person : department.getPerson_arr()) {
			System.out.println(person.getName());
		}
	}

	/**
	 * List的依赖注入: 1.有序 2.可包含多个相同对象
	 */
	@Test
	public void test5() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Department department = (Department) ac.getBean("department3");

		for (Person person : department.getPerson_list()) {
			System.out.println(person.getName());
		}
	}

	/**
	 * Set的依赖注入: 1.无序 2.不包含重复对象（相同的对象中取最后一个进行覆盖）
	 */
	@Test
	public void test6() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Department department = (Department) ac.getBean("department4");

		for (Person person : department.getPerson_set()) {
			System.out.println(person.getName());
		}
	}

	/**
	 * @author milo
	 * @version 1.0
	 * @see Main
	 * @since Di 1.0
	 * @exception Exception no exception
	 * {@link Main}<br>
	 * <p>Map的依赖注入</p>
	 * {@docRoot Main}
	 * 
	 */
	@Test
	public void test7() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Department department = (Department) ac.getBean("department5");

		Map<String, Object> person = department.getPerson_map();

		// 1.迭代器
		Iterator<Object> iterator = person.values().iterator();
		while (iterator.hasNext()) {
			Person person1 = (Person) iterator.next();
			System.out.println(person1.getName());
		}

		// 2.Entry
		for (Entry<String, Object> e : person.entrySet()) {
			System.out.println(e.getKey() + " "
					+ ((Person) e.getValue()).getName());
		}
	}
	
	@Test
	public void test8() {
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		Department department = (Department) ac.getBean("department6");
		
		Properties pp = department.getPp();
		
		// Entry
		Set<Entry<Object, Object>> entrys = pp.entrySet();
		
		for(Entry<Object, Object> e : entrys) {
			System.out.println(e.getKey() + " " + e.getValue() );
		}
		
		// 通过枚举
		Enumeration<Object> enumeration = pp.elements();
		while(enumeration.hasMoreElements()) {
			String obj = (String)enumeration.nextElement();
			System.out.println(obj);
		}
		
		// Set
		Set<Object> set = pp.keySet();
		for(Object obj : set) {
			System.out.println(pp.get(obj));
		}
		
		// Collection
		Collection<Object> values = pp.values();
		Iterator iterator = values.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
