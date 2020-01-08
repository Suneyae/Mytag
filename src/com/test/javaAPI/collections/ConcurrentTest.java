package com.test.javaAPI.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Wei
 * @time  2017年4月10日 上午11:05:17
 */
public class ConcurrentTest {

	public ConcurrentTest() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> cmap = new ConcurrentHashMap<String, Object>();
		
		cmap.put("xx", 234);
	}
	
}
