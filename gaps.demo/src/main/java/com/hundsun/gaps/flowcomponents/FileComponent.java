package com.hundsun.gaps.flowcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class FileComponent {
	public static String read(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream fin = new FileInputStream(file);

		List<String> list = IOUtils.readLines(fin, "UTF-8");
		StringBuffer sb = new StringBuffer();
		for (String str : list) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static void save(String string, String filePath) throws IOException {
		File file = new File(filePath);	
		if (file.exists()) {
			file.delete();
		}
		new File(file.getParent()).mkdirs();
		file.createNewFile();

		FileOutputStream fout = new FileOutputStream(file);

		IOUtils.write(string, fout, "UTF-8");
	}

	public static void append(String path1, String path2) throws IOException {
		File file = new File(path1);
		if (!file.exists()) {
			file.createNewFile();
		}
		String str1 = read(path1);
		String str2 = read(path2);
		save(new StringBuffer(str1).append('\n').append(str2).toString(), path1);
	}

	public static long getLength(String str) {
		File file = new File(str);
		if (file.exists()) {
			return file.length();
		}
		return 0;
	}
}
