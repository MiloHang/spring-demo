package com.hss.myspring.v1.container;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hss.myspring.v1.annotation.MyBean;
import com.hss.myspring.v1.annotation.MyResource;

/**
 * 手写Spring容器：
 * <p>1.实现包内文件.class文件检索</p>
 * <p>2.类注解扫描</p>
 * <p>3.字段注解扫描</p>
 * @author milo
 *
 */
public class MyApplicationContext {
	
	// 描述指定包下以及子包下的所有类型
	private static String BASE_PACK = "com.hss.myspring.v1";

	private static Map<String, Object> map = new HashMap<String, Object>();
	private static Map<Class<?>, Object> map2 = new HashMap<Class<?>, Object>();
	
	// 进行解析
	static {
		try {
			String base = BASE_PACK.replaceAll("\\.", "/");
			String root = MyApplicationContext.class.getClassLoader().getResource(base).toURI().getPath();
			
			File dir = new File(root);
			List<String> list = new ArrayList<String>();
			listDir(dir, list);
			
			List<String> clsList = new ArrayList<String>();			
			for(String str : list) {
				str = str.substring(dir.getCanonicalPath().length());
				str = str.replace(".class", "");
				str = str.replaceAll("\\\\", ".");
				str = BASE_PACK + str;
				clsList.add(str);
			}
			
			// 分析类型上是否标注了注解
			for(String cls : clsList) {
				Class<?> clazz = Class.forName(cls);
				MyBean mybean = (MyBean)clazz.getAnnotation(MyBean.class);
				if(mybean != null) {
					// 进行装配
					String id = mybean.value();
					if(id.equals("")) { //默认值
						String name = clazz.getSimpleName();
						id = name.substring(0, 1).toLowerCase() + name.substring(1);
					}
					Object bean = clazz.newInstance();
					map.put(id, bean);
					map2.put(clazz, bean);
				}				
			}
			
			// 分析各类的字段上是否存在注解
			Set<Class<?>> keys = map2.keySet();
			for(Class<?> clz : keys) {
				Field[] fds = clz.getDeclaredFields();
				for(Field fd : fds) {
					if(fd.isAnnotationPresent(MyResource.class)) { // 如果字段上存在MyResource注解
						// 根据名称进行bean查询
						String fname = fd.getName(); // 字段的名字
						Object ref = map.get(fname); // 根据id进行bean的查询,<bean id="$fname" />
						Object bean = map2.get(clz); // 根据类型进行bean的查询<bean class="$clz" />
						if(!fd.isAccessible()) { // 字段不可访问
							fd.setAccessible(true); // 解除不可访问限制
							fd.set(bean, ref); // 注入spring中维护的bean
							fd.setAccessible(false); // 恢复不可访问限制
						} else {
							fd.set(bean, ref); // 直接注入字段值
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listDir(File file, List<String> list) {
		if(file.isFile()) {
			try {
				String path = file.getCanonicalPath(); 
				if(path.endsWith(".class")) {
					list.add(path);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		File[] fs = file.listFiles();
		for(File f : fs) {
			listDir(f, list);
		}
	}
	
	
	public Object getBean(String id) {
		return map.get(id);
	}
	
	public <T> T getBean(Class<T> clazz) {
		return (T)map2.get(clazz);
	}
	
	public static void main(String[] args) {
		
	}
}
