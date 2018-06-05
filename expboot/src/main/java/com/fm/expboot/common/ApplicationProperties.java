package com.fm.expboot.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件映射对象
 *
 */
@Component
@ConfigurationProperties(prefix = "cfg", ignoreUnknownFields = false)
public class ApplicationProperties {

	private Map<String, String> service;

	@Value("${third.url}")
	private String thirdUrl;

	public Map<String, String> getService() {
		return service;
	}

	public void setService(Map<String, String> service) {
		this.service = service;
	}

	public String getThirdUrl() {
		return thirdUrl;
	}

	public void setThirdUrl(String thirdUrl) {
		this.thirdUrl = thirdUrl;
	}

}