package com.hss.propertyeditor.entity;

import java.util.Date;

public class User {
	
	private String upperName;
	private String lowerName;
	
	private int age;
	private Date date;
	
	public String getUpperName() {
		return upperName;
	}
	public void setUpperName(String upperName) {
		System.out.println("setUpperName " + upperName);
		this.upperName = upperName;
	}
	public String getLowerName() {
		return lowerName;
	}
	public void setLowerName(String lowerName) {
		this.lowerName = lowerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		System.out.println("setDate... " + date);
		this.date = date;
	}
}
