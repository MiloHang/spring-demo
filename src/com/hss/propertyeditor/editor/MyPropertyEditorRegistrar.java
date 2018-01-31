package com.hss.propertyeditor.editor;


import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.hss.propertyeditor.entity.User;

/**
 * 属性编辑器注册员
 * @author 60512
 *
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

	/**
	 * 注册属性编辑器
	 * @param registry 注册中心
	 */
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(java.util.Date.class, new DatePropertyEditor());
		registry.registerCustomEditor(User.class, new UserPropertyEditor());
	}
}
