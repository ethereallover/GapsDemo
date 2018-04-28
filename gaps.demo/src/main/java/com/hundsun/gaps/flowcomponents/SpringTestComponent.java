package com.hundsun.gaps.flowcomponents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.hundsun.gaps.flowexecutor.annotations.GapsParameter;

public class SpringTestComponent {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${jdbc.databaseType}")
	private String a;

	@GapsParameter("jdbc.databaseType")
	private String b;

	@GapsParameter(value = "jdbc.databaseType", dynamic = false)
	private String c;

	public void test() {
		logger.info("当前属性a={},b={},c={}", a, b, c);
	}
}
