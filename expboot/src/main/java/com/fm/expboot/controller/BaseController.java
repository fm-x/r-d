package com.fm.expboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fm.expboot.common.ApplicationProperties;

@Component
public class BaseController {

	@Autowired
	protected ApplicationProperties appPro;

}
