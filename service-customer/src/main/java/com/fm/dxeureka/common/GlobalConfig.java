package com.fm.dxeureka.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 配置中心
 * 
 * @author XSD
 */
@RefreshScope
@Configuration
public class GlobalConfig {

	@Value("${my.file}")
	private String file;

	@Value("${my.des}")
	private String des;

	public String getFile() {
		return file;
	}

	public String getDes() {
		return des;
	}

	@Override
	public String toString() {
		return "GlobalConfig [file=" + file + ", des=" + des + "]";
	}

}
