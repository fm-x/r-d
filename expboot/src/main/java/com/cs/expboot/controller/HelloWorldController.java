package com.cs.expboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.expboot.domain.User;
import com.cs.expboot.util.CfgProperties;
import com.cs.expboot.util.SpringUtil;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

	@RequestMapping("/user")
	public Object user() {
		User user = new User();
		user.setUserName("南京");
		user.setPassword("===");
		user.setAge(100);
		return user;
	}
	
	@RequestMapping("/cfg")
	public Object cfg() {
		CfgProperties pro = SpringUtil.getBean(CfgProperties.class);
		System.err.println(pro);
		return pro;
	}

}