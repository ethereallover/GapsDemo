package com.hundsun.gaps.flowcomponents;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddNum {
	private Logger log = LoggerFactory.getLogger(getClass());

	public BigDecimal add(BigDecimal a, BigDecimal b) throws Exception {
		BigDecimal c = a.add(b);
		log.info("加法执行【{}+{}={}】", a, b, c);
		return c;
	}
}
