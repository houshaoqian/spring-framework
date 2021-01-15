package com.qiriver.test;


import com.qiriver.spring.user.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.log.MyLogger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;

/**
 * 测试BeanPostProcessor#postProcessAfterInitialization的后置通知 和 InitializingBean的执行时机对比
 */

public class TimingBean implements BeanPostProcessor, InitializingBean {
	static {
		MyLogger.log("TimingBean static init...");
	}
	@Resource
	UserDao usreDao;

	@Override
	public void afterPropertiesSet() throws Exception {
		MyLogger.log("TimingBean#afterPropertiesSet执行,usreDao=" + usreDao);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		MyLogger.log("TimingBean#postProcessBeforeInitialization执行, usreDao="+usreDao);
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		MyLogger.log("TimingBean#postProcessAfterInitialization执行, usreDao="+usreDao);
		return null;
	}
}
