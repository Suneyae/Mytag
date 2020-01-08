package com.test.javaAPI.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import com.util.UtilPrint;

/**
 * 通过数组实现一个简单的map
 * 
 * @author Wei
 * @time 2016年10月2日 下午2:22:57
 */
public class MyMap3 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Java", 8);
		map.put("Csharp", 5);
		Integer value = map.compute("Java", new BiFunction<String, Integer, Integer>() {
			public Integer apply(String t, Integer u) {
				System.out.println("t : " + t + ", u : " + u);
				UtilPrint.printWithSeparatorAndClass("--------------", MyMap3.class);
				return 2;
			}
		});
		for (Map.Entry<String, Integer> entry : map.entrySet())
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
	}
}
