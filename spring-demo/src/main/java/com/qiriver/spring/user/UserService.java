package com.qiriver.spring.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Tt
 * 
 * @author sheart7
 * @date 2020-09-24
 */
@Service
public class UserService {

	@Resource
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
