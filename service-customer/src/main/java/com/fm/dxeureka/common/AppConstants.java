package com.fm.dxeureka.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * 项目配置
 * 
 * @author XSD
 */
@Component
public class AppConstants {

	@Value("${producer.tag.msg}")
	public String tagMsg;

	@Value("${producer.serviceId.msg}")
	public String serviceIdMsg;

}
