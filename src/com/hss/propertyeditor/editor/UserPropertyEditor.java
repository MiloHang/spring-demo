package com.hss.propertyeditor.editor;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import com.hss.propertyeditor.entity.User;

public class UserPropertyEditor extends PropertyEditorSupport {

	@Override
	public Object getValue() {
		System.out.println("getValue..");
		return super.getValue();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("用户编辑器调用方法setAsText。。。");
		System.out.println(text);
		User user = new User();
		user.setLowerName("milo");
		user.setUpperName("MILO");
		user.setAge(19);
		user.setDate(new Date());
		super.setValue(user);
	}
}
