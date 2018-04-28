package com.hundsun.gaps.flowexecutor.factory;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.hundsun.gaps.flowexecutor.GapsFlowRunner;

@RunWith(value = SpringRunner.class)
@ContextConfiguration("classpath*:application-context.xml")
public class SpringFlowTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private final static int THREAD_NUMBER = 1;

	@Test
	public void start() {
		try {
			for (int n = 1; n <= THREAD_NUMBER; n++) {
				Map<String, Object> context = new HashMap<>();
				GapsFlowRunner runner = new GapsFlowRunner("db9ac5718a1a475ca00465d1bfae1666", context);
				Map<String, Object> resp = runner.run();
				logger.info("\n\n返回结果:{}", JSON.toJSON(resp).toString());

			}
			Thread.sleep(1000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
