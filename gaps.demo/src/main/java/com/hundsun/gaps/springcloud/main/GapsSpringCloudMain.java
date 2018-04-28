package com.hundsun.gaps.springcloud.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SpringCloud启动主函数类<br>
 * 本身仅仅调用支持包中的启动函数,避免环境中不存在SpringCloud运行环境而无法编译
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年4月26日
 */
public class GapsSpringCloudMain {

	private static final String SPRING_BOOT_RUNNER = "com.hundsun.gaps.springcloudsuport.GapsSpringCloudRunner";

	private static final Logger logger = LoggerFactory.getLogger(GapsSpringCloudMain.class);

	public static void main(String[] args) {

		try {
			Class<?> clazz = Class.forName(SPRING_BOOT_RUNNER);
			Method method = clazz.getMethod("run", String[].class);
			method.setAccessible(true);
			method.invoke(clazz, new Object[] { args });
		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			logger.error("", t);
		} catch (ClassNotFoundException e) {
			logger.error("不存在SpringCloud支持环境,无法运行");
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			logger.error("", e);
		}

	}
}
