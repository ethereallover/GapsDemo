package com.hundsun.gaps.flowcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import java.lang.String;

public class ReadString {

	public static String read(String filePath) throws IOException{
		File file = new File(filePath);
		FileInputStream fin = new FileInputStream(file);
		List<String> list = IOUtils.readLines(fin, "UTF-8");
		StringBuffer sb = new StringBuffer();
		for (String str : list) {
			sb.append(str);
		}
		return sb.toString();
	}
}
