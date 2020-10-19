package com.qiriver.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.log.MyLogger;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		MyLogger.log("自定义BeanFactoryPostProcessor.postProcessBeanFactory()");
		MyLogger.log("beanFactory Count=" + beanFactory.getBeanDefinitionCount());
	}
}
