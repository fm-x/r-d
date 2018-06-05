package com.fm.expboot;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.fm.expboot.db.mapper")
public class ExpbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpbootApplication.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer loadSources() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//		yaml.setResources(new FileSystemResource("pro/service-resp-mapping.yml"));// File引入
		 yaml.setResources(new ClassPathResource("pro/service-resp-mapping.yml"));//classpath引入
		configurer.setProperties(yaml.getObject());
		return configurer;
	}

}
