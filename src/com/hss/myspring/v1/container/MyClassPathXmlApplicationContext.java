package com.hss.myspring.v1.container;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 * 手写ClassPathXmlApplicaitonContext
 * 完成功能：
 * 1.利用dom4j技术解析xml文件
 * 2.使用XPath语法进行依赖注入
 * @author milo
 *
 */
public class MyClassPathXmlApplicationContext {

	private Map<String, Object> map = new HashMap<String, Object>();
	
	@SuppressWarnings("unchecked")
	public MyClassPathXmlApplicationContext(String xml) {
		// 1、读取xml文件并进行解析
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			URL xmlpath = this.getClass().getClassLoader().getResource(xml);
			document = saxReader.read(xmlpath);
			Map<String, String> nsMap = new HashMap<String, String>();
			nsMap.put("xmlns", "http://www.springframework.org/schema/beans");	//命名空间
			
			// 使用XPath语法
			XPath xsub = document.createXPath("//xmlns:beans/xmlns:bean"); //创建beans/bean查询路径
			xsub.setNamespaceURIs(nsMap);// 设置命名空间
			List<Element> beans = xsub.selectNodes(document);// 获取文档下所有bean节点
			
			// 1、bean的装配
			for (Element element : beans) {
				String id = element.attributeValue("id");// 获取id属性值
				String cname = element.attributeValue("class"); // 获取class属性值
				
				Class<?> clazz = Class.forName(cname);
				Object obj = clazz.newInstance();
				map.put(id, obj);
			}
			
			// 2、依赖注入
			for (Element element : beans) {
				String id = element.attributeValue("id");
				Object bean = map.get(id);
				List<Element> props = element.elements();
				for(Element elm : props) {
					// 进行属性注入
					String ref = elm.attributeValue("ref");
					Object obj = map.get(ref);
					
					String name = elm.attributeValue("name");
					BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
					PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
					for(PropertyDescriptor pd : pds) {
						if(pd.getName().equals(name)) {
							Method method = pd.getWriteMethod();
							method.invoke(bean, obj);
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String name) {
		return map.get(name);
	}
}
