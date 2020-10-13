package com.qiriver.test;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * test
 * 
 * @author sheart7
 * @date 2020-10-13
 */

@Component
@PropertySource("config.properties")
public class PropertySourceConfig {
	
	private String ulna;
	
	private String ulnb;

	public String getUlna() {
		return ulna;
	}

	public void setUlna(String ulna) {
		this.ulna = ulna;
	}

	public String getUlnb() {
		return ulnb;
	}

	public void setUlnb(String ulnb) {
		this.ulnb = ulnb;
	}
}
