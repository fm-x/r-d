package com.fm.dxeureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

	@Value("${spring.application.name}")
	private String appName;

	@Value("${server.port}")
	private Integer port;

	@RequestMapping("/notice")
	public String notice(@RequestParam String obj) {
		System.out.println("request2 obj is " + obj);
//		if (StringUtils.contains(obj, "abc")) {
//			throw new RuntimeException("服务异常...");
//		}
//		try {
//			Thread.sleep(1000*1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return "The service of " + appName + "[" + port + "]provides the service to push messages to " + obj;
	}
	
	/*
	 *  RabbitMQ: http://localhost:15672
	 *  http://localhost:9001/actuator/bus-refresh
	 */
}
