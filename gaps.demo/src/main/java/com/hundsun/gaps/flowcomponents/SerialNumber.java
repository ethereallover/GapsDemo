package com.hundsun.gaps.flowcomponents;

import java.lang.String;

public class SerialNumber {
	private static long number = 0L;

	public static synchronized String getSerialId(){
		number++;
		return String.format("%08d", number);
	}
}
