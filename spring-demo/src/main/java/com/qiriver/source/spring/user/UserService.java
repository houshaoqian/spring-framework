package com.qiriver.source.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user){
		System.out.println("UserService.save...");
		userDao.save(user);
	}

	public User getUser(String name){
		System.out.println("UserService.getUser...");
		return userDao.getUser(name);
	}
}
