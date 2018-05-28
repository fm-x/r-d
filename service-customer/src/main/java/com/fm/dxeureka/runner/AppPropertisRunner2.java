package com.fm.dxeureka.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AppPropertisRunner2 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Runer2 start to initialize ...");
//		for (String s : args.getOptionNames()) {
//			System.out.println(s + "->"+args.getOptionValues(s));
//		}
//		System.out.println(args.getNonOptionArgs());
//		System.out.println(Arrays.asList(args.getSourceArgs()));
		
	}

}
