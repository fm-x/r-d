package com.fm.expboot.common.runner;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fm.expboot.common.ApplicationProperties;

@Component
@Order(0)
public class AppCFGRunner implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppCFGRunner.class);

	@Autowired
	protected ApplicationProperties appPro;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Map<String, String> serviceMap = appPro.getService();
		String appName = appPro.getAppName();
		if (CollectionUtils.isEmpty(serviceMap)) {
			LOGGER.error("{} service-resp-mapping initialize failed.", appName);
		} else {
			LOGGER.info("{} service-resp-mapping property initialize success.", appName);
		}
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer loadSources() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		// yaml.setResources(new FileSystemResource("pro/service-resp-mapping.yml"));// File引入
		yaml.setResources(new ClassPathResource("pro/service-resp-mapping.yml"));// classpath引入
		configurer.setProperties(yaml.getObject());
		return configurer;
	}

}
