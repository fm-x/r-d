package com.fm.dxeureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fm.dxeureka.common.AppConstants;

@Component
@RefreshScope
public class BaseController {

	@Autowired
	protected AppConstants appConstants;
	
	@Autowired
	protected RestTemplate restTemplate;

	@Value("${my.des}")
	protected String cfg;
	
	protected static String noticeCallback(String obj) {
		return "[Fm-service-producer] service exception, unable to provide services to " + obj;
	}

}
