package com.hss.aop.aspect.service.impl;

import com.hss.aop.aspect.service.BaseService;

public class BaseServiceImpl implements BaseService {
	public void log() {
		System.out.println("基础日志开始记录...");
	}
}
