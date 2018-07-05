package com.fm.dxeureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fm.dxeureka.common.AppConstants;
import com.fm.dxeureka.common.GlobalConfig;

@Component
public class BaseController {

	@Autowired
	protected AppConstants appConstants;

	@Autowired
	protected GlobalConfig config;

	@Autowired
	protected RestTemplate restTemplate;

	protected static String noticeCallback(String obj) {
		return "[Fm-service-producer] service exception, unable to provide services to " + obj;
	}

}
