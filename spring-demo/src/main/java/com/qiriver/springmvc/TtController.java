package com.qiriver.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TtController {

	public TtController() {
		System.out.println("TtController构造函数");
	}

	@RequestMapping("/tt1")
	public String t1(String name) {
		return "Hi, " + name;
	}

}
