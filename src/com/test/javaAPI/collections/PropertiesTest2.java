package com.test.javaAPI.collections;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesTest2 {
	private static String PROP_PATH = "/com/test/javaAPI/collections/wyl.properties";
	public PropertiesTest2() {
	}
	
	public static void main(String[] args) {
		Map<String,Object> map = propsToMap(PROP_PATH);
		System.out.println(map);
	}
	
	@SuppressWarnings("all")
	public static Map<String,Object> propsToMap(String propsPath){
		if("".equals(propsPath)||null==propsPath){
			try {
				throw new Exception("Properties文件的路径不能为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		propsPath = "/com/test/javaAPI/collections/wyl.properties";
		InputStream is = PropertiesTest2.class.getResourceAsStream(propsPath);
		Properties props = new Properties();
		Map<String,Object> map = new HashMap<String,Object>();
		if(null==is){
			try {
				throw new Exception("没有找到对应的properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				props.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
		 * properites转换为map的关键点在于props.propertyNames()这个方法，
		 * 然后对生成的Enumeration对象进行处理
		 */
		Enumeration<Object> em = (Enumeration<Object>) props.propertyNames();
		while (em.hasMoreElements()) {
			String key = (String)em.nextElement();
			String value = props.getProperty(key);
			map.put(key, value);
		}
		return map;
	}
}
