package com.wyl.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonObjTest {
	public static void main(String[] args) {
	}

	private static ObjectMapper jsonObjParser1 = null;

	public static Object JsonToObj(String jsonObj) {
		jsonObjParser1 = new ObjectMapper();
		Object[] json = null;
		try {
			json = (Object[]) jsonObjParser1.readValue(jsonObj, Object.class);

		} catch (JsonParseException e) {
			System.out
					.println("JsonObjTest.JsonToObj()方法异常，JsonParseException....");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out
					.println("JsonObjTest.JsonToObj()方法异常，JsonMappingException....");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("JsonObjTest.JsonToObj()方法异常，IOException....");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 例子：入参： parameters:[{"serviceId":"MyAjax","method":"myAjax","parameters":{
	 * "CRXX":234}}] 用parameters.split(",");后的情况为： [{"serviceId":"MyAjax"
	 * "method":"myAjax" "parameters":{"CRXX":234}}]
	 * 
	 * 
	 * @param para
	 * @return
	 */
	public static String[] StringToArray(String para) {
		String[] array = para.split(",");
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = array[i].replace("[{", "");
			}
			System.out.println(array[i]);
		}
		
		System.out.println("array:" + array);
		return array;
	}

	/**
	 * 把类似于： "method":"myAjax" 的字符串解析出来放到map里
	 * 
	 * @param para
	 * @return
	 */
	public static Map StringObjToMap(String para) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] str = para.split(":");
		String key = str[str.length - 1];
		String value = str[str.length];
		return  (Map) map.put(key, value);
	}
	
	/**
	 * 
	          例子：入参： parameters:[{"serviceId":"MyAjax","method":"myAjax","parameters":{"CRXX":234}}] 
	          用parameters.split(",");后的情况为：
	  [{"serviceId":"MyAjax"
	  "method":"myAjax" 
	  "parameters":{"CRXX":234}}]
	  
	  
	 * @param para
	 * @return
	 */
	public static Map StringToMap(String para) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] array = para.split(",");
		int len = array.length;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = array[i].replace("[{", "");
				String[] str = array[i].split(":");
				String key = str[0];
				String value = str[1];
				map.put(key, value);
			}else if(i==len-1){
				// array[i] =  "parameters":{"CRXX":234}}]
				array[i] = array[i].replace("}]", "");
				String[] str = array[i].split(":");
				String key = str[0];
				String value = str[1];
				map.put(key, value);
			}else{
				String[] str = array[i].split(":");
				String key = str[0];
				String value = str[1];
				map.put(key, value);
			}
//			System.out.println("i:"+i+",map"+map);
			System.out.println("array["+i+"] = "+array[i]);
		}
		System.out.println("array:" + array);
		return map;
	}
	/**
	 * 使用jacksonall的API进行json字符串的解析
	 * @param para
	 * @return
	 */
	public static BeanService StringToMapByJacksonall(String para) {
		BeanService bean = new BeanService();
		ObjectMapper objMap = new ObjectMapper();
		try {
			bean = objMap.readValue(para, BeanService.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	/**
	 * 比如一个字符串是 "aaaa",把两侧的引号去掉
	 * @return
	 */
	public String myTrim(String para){
		para = para.replace("\"", "");
		return para;
	}

}
