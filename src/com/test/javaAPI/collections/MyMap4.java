package com.test.javaAPI.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * 测试Map.compute()方法，这是java1.8以后的新特性
 * 
 * @author Wei
 * @time 2016年10月2日 下午2:45:34
 */

public class MyMap4 {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 2432);
		map.put("b", "798aA");

		map.compute("a", new BiFunction<String, Object, Object>() {

			@Override
			public Object apply(String t, Object u) {
				System.out.println("t:" + t + ",u:" + u);
				return 42342;
			}
		});

		Set<Map.Entry<String, Object>> set = map.entrySet();

		Iterator<Entry<String, Object>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, Object> e = it.next();
			System.out.println("key:" + e.getKey() + ",value:" + e.getValue());
		}

	}
}
