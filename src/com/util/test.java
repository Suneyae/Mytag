package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 测试各种工具方法
 * 
 * @author Wei
 * @time 2016年9月26日 下午8:57:54
 */
public class test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, FileNotFoundException, IOException, WylException {
		InputStream ips = UtilProprerties.getResourceAsInputStream(UtilProprerties.PATH_DB_PROPERTIES);
		Properties props = new Properties();
		props.load(ips);

	}
}
