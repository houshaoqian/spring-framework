package com.qiriver.spring.user;

import lombok.Data;

@Data
public class User {

	private String name;

	private Long age;

	public User() {
	}

	public User(String name, Long age) {
		this.name = name;
		this.age = age;
	}
}
