package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 集合工具类
 * 
 * @author Wei
 * @time 2016年10月2日 上午10:20:25
 */
public class UtilCollections {
	private UtilCollections() {

	}

	/**
	 * 生成指定长度的Map
	 * 
	 * @param key
	 *            Map的key
	 * @param value
	 *            值
	 * @param len
	 *            长度,如果传入的值小于1,那么len默认为10
	 */
	public static Map<String, String> generateMap(String key, String value, int len) {
		Map<String, String> map = new HashMap<String, String>();
		if (len < 1) {
			len = 10;
		}
		for (int i = 0; i < len; i++) {
			map.put(key + i, value + i);
		}
		return map;

	}
}
