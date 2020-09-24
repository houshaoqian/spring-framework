package com.qiriver.springmvc;

import com.qiriver.spring.user.User;
import com.qiriver.spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
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
