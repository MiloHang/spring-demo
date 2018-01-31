package com.hss.propertyeditor.editor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatePropertyEditor extends PropertyEditorSupport {

	private List<String> patterns = new ArrayList<String>(){{
		add("yyyy-MM-dd");		
		add("yyyy-MM-dd HH:mm");
		add("yyyy-MM-dd HH:mm:ss");
	}};

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("调用日期属性编辑器方法。。。");
		for(String pattern : patterns) {
			if(pattern.length() == text.length()) {
				DateFormat df = new SimpleDateFormat(pattern);
				try {
					Date ctime = df.parse(text);
					setValue(ctime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}	
}
