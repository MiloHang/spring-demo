package com.hss.applicaiton_context.service;

public class ChangeToUpper implements ChangeLetter {

	private String s;
	@Override
	public String change(String s) {
		return s.toUpperCase();
	}

	@Override
	public String change() {
		return s.toUpperCase();
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
}
