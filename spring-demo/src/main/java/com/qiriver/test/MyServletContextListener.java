package com.qiriver.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce){
		System.out.println("MyServletContextListener.contextInitialized....");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce){
		System.out.println("MyServletContextListener.contextDestroyed....");
	}
}
