package com.hundsun.gaps.flowcomponents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintAll{
	private Logger log = LoggerFactory.getLogger(PrintAll.class);
	public void print(Object a) throws Exception{
		log.info("输出获取到的参数：{}",a);
	}
}
