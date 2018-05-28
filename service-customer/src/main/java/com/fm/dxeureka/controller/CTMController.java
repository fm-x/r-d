package com.fm.dxeureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fm.dxeureka.feign.MsgRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class CTMController extends BaseController {

	@Autowired
	MsgRemote msgRemote;

	@RequestMapping("/test1")
	@HystrixCommand(fallbackMethod = "noticeCallback", commandProperties = { @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE") })
	public String ctmAction1(@RequestParam String obj) {
		return restTemplate.getForObject("http://fm-service-producer/msg/notice?obj=" + obj, String.class);
	}

	@RequestMapping("/test2")
	public String ctmAction2(@RequestParam String obj) {
		return msgRemote.rcNotice(obj);
	}

	@RequestMapping("/cfg")
	public String cfgEvent() {
		return cfg;
	}

	// http://localhost:10101/fm-service-producer/msg/notice?obj=%E4%B8%AD%E5%9B%BD
}
