package com.qiriver.source.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public void save(User user){
		System.out.println("UserController.save...");
		userService.save(user);
	}

	@RequestMapping("/t1")
	public User getUser(String name){
		System.out.println("UserController.getUser...");
		return userService.getUser(name);
	}

	@RequestMapping("/t2")
	public String t2(String name){
		return "Hi.";
	}
}
