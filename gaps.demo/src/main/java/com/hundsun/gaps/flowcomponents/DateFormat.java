package com.hundsun.gaps.flowcomponents;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;
import java.lang.Long;

public class DateFormat {

	/**
	 * 日期格式化函数
	 */
	public static String dateFormat(Long timestamp, String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date(timestamp));
	}

	/**
	 * 根据当前操作系统时间生成时间戳，毫秒级
	 */
	public static Long getTimeStamp(){
		return System.currentTimeMillis();
	}

}
