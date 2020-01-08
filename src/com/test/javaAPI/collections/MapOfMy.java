package com.test.javaAPI.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 
 * @author Wei
 * @time  2017年4月7日 下午2:16:15
 */
public class MapOfMy {

	public MapOfMy() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		Hashtable t = new Hashtable<String, Object>();
		
		
		map.put(null, null);
		map.put("23","daf");
		System.out.println(map);
		
		
		t.put(null, 123412);
		System.out.println(t);
		
	}
}
