package com.qiriver.test;

import org.springframework.core.log.MyLogger;

public class PlaceHolderBean {
	
	private String name;

	public PlaceHolderBean(String name) {
		MyLogger.log("PlaceHolderBean construct,name=" + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
