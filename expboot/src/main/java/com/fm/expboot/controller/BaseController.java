package com.fm.expboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fm.expboot.common.ApplicationProperties;

@Component
public class BaseController {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected ApplicationProperties appPro;

}
