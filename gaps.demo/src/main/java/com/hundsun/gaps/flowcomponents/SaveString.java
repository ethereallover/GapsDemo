package com.hundsun.gaps.flowcomponents;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class SaveString {
	public static String save(String string, String filePath) throws IOException {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
		new File(file.getParent()).mkdirs();
		file.createNewFile();

		FileOutputStream fout = new FileOutputStream(file);

		IOUtils.write(string, fout, "UTF-8");
		return filePath;
	}
}
