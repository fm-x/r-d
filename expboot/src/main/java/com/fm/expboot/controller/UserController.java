package com.fm.expboot.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.expboot.db.model.User;
import com.fm.expboot.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/get")
	public Object query(User user) {
		List<User> users = userService.getAll(user);
		PageInfo<User> userPage = new PageInfo<User>(users);
		LOGGER.info("" + userPage);
		return users;
	}

	@RequestMapping("/add")
	public Object add(User user) {
		if (user != null) {
			int rows = userService.merge(user);
			LOGGER.info("influenced rows:" + rows);
		}
		return user;
	}

	@RequestMapping("/cfg")
	public Object cfg() {
		Map<String, String> cfgMap = appPro.getService();
		LOGGER.info("->" + cfgMap);
		LOGGER.info("thirdUrl[{}]", appPro.getThirdUrl());
		return cfgMap;
	}

}
