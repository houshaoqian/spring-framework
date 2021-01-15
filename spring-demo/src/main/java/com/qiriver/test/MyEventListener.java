package com.qiriver.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.log.MyLogger;
import org.springframework.stereotype.Service;

@Service
public class MyEventListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		MyLogger.log("事件已被接收:" + event);
	}
}
