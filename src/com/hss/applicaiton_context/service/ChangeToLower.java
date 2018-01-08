package com.hss.applicaiton_context.service;

public class ChangeToLower implements ChangeLetter {
	private String s;
	
	@Override
	public String change() {
		return s.toLowerCase();
	}

	@Override
	public String change(String s) {
		return s.toLowerCase();
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
}
