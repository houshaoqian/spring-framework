package com.qiriver.spring.user;

import org.springframework.stereotype.Repository;

/**
 * tt
 * 
 * @author sheart7
 * @date 2020-09-24
 */
@Repository
public class UserDao {

	public void save(User user){
		System.out.println("UserDao.save..." + user);
	}

	public User getUser(String name){
		System.out.println("UserDao.getUser...");
		return new User(name, System.currentTimeMillis());
	}
}
