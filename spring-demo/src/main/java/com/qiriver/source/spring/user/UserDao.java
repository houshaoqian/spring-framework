package com.qiriver.source.spring.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public void save(User user){
		System.out.println("UserDao.save...");
	}

	public User getUser(String name){
		System.out.println("UserDao.getUser...");
		return new User(name, System.currentTimeMillis());
	}
}
