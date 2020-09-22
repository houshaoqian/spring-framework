package com.qiriver.source.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Tt {

	public static void main(String[] args) {
		System.out.println("start...");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		int total = context.getBeanDefinitionCount();
		System.out.println("befor scan total=" + total);
		context.scan("com.qiriver.source.spring");
		total = context.getBeanDefinitionCount();
		System.out.println("after scan total=" + total);
		System.out.println("over.");

	}

}
