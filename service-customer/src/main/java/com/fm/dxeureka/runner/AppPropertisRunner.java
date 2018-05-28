package com.fm.dxeureka.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

import com.fm.dxeureka.common.AppConstants;
import com.fm.dxeureka.common.filter.AuthenticationFilter;

@Configuration
@Order(0)
public class AppPropertisRunner implements CommandLineRunner {

	public static String tagMsg;

	@Autowired
	private AppConstants appConstants;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("start to initialize ...");
		if (args != null) {
			System.out.println("args:" + Arrays.asList(args));
		}
		tagMsg = appConstants.tagMsg;
		System.out.println("tagMsg:" + tagMsg);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AuthenticationFilter authenticationFilter() {
		return new AuthenticationFilter();
	}

}
