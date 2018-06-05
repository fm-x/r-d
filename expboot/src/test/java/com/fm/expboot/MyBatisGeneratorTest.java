package com.fm.expboot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorTest {

	String genCfg = "/generator/generator-config.xml";
	File configFile = null;

	@Before
	public void init() throws Exception {
		configFile = new File(MyBatisGeneratorTest.class.getResource(genCfg).getFile());
	}

	@Test
	public void build() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		ConfigurationParser parser = new ConfigurationParser(warnings);
		Configuration config = parser.parseConfiguration(configFile);

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

		myBatisGenerator.generate(null);
	}

}
