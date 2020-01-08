package com.test.javaAPI.json;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class JacksonTest2 {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String str = new JacksonTest2().removeJsonObjByKey(UtilJackson.jsonStr4, UtilJackson.jsonStr4_KEY1);
		System.out.println(str);
	}

	/**
	 * 根据键除去json格式字符串中的某一个键值对
	 * 
	 * @param jsonStr
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public String removeJsonObjByKey(String jsonStr, String key)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMap = new ObjectMapper();
		// 1 把json格式字符串转换为 java.util.Map
		Map map = objMap.readValue(jsonStr, Map.class);
		// 2 删除map中的对应key的项目
		map.remove(key);
		// 准备字节流，接收ObjectMapper中写出的输出流
		ByteOutputStream bops = new ByteOutputStream();
		// 3 把map重新转换为json格式字符串
		objMap.writeValue(bops, map);
		if (!"".equals(bops)) {
			return bops.toString();
		}
		return "";
	}

	/**
	 * 方法的作用：去除一个json格式字符串的某一个key 删除 这个json字符串里的这个key对应的对象 该方法与框架中的 String
	 * cn.sinobest.framework.web.his.JsonManager.removeDataPackage(String
	 * jsonStr) 这个方法的功能一致
	 * 
	 * @param jsonKey
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public String removeDataPackage(String jsonKey) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMap = new ObjectMapper();
		Map map = objMap.readValue(UtilJackson.jsonStr_HN, Map.class);
		// map.remove("DataPackage");
		map.remove(jsonKey);
		ByteOutputStream bops = new ByteOutputStream();
		objMap.writeValue(bops, map);
		System.out.println(bops.toString());
		return null;
	}

}
