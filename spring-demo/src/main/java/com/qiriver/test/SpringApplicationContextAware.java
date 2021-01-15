package com.qiriver.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.log.MyLogger;

public class SpringApplicationContextAware implements ApplicationContextAware {


	ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		MyLogger.log("SpringApplicationContextAware已被注入.");
		context = applicationContext;
		applicationContext.publishEvent("[SpringApplicationContextAware已被注入]事件已被广播");
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}
