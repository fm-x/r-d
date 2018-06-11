package com.fm.expboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.fm.expboot.db.mapper")
public class ExpbootApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExpbootApplication.class, args);
		LOGGER.info("ExpbootApplication Startup complete.");
	}

}
