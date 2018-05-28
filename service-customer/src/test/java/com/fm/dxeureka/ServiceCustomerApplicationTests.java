package com.fm.dxeureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceCustomerApplicationTests {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Test
	public void logbackLog() {
		LOGGER.debug("This is a debug {} message", "test");
		LOGGER.info("This is an info message");
		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message");
	}

}
