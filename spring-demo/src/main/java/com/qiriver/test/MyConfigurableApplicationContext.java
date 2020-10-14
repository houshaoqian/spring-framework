package com.qiriver.test;


import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.log.MyLogger;
import org.springframework.web.context.ConfigurableWebApplicationContext;

public class MyConfigurableApplicationContext implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

	@Override
	public void initialize(ConfigurableWebApplicationContext applicationContext) {
//		MyLogger.log("MyApplicationContextInitializer在Spring容器启动前回调该方法.当前bean数量=" + applicationContext.getBeanDefinitionCount());
//		MyLogger.log("当前bean分别是************" + applicationContext.getBeanDefinitionNames());
//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		for (int i = 0; i < beanDefinitionNames.length; i++) {
//			MyLogger.log(beanDefinitionNames[i]);
//		}

		MyLogger.log("MyApplicationContextInitializer在Spring容器启动前回调该方法.");
	}
}
