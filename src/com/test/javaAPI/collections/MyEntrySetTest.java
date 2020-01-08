package com.test.javaAPI.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.util.UtilCollections;
import com.util.UtilPrint;

/**
 * Map.Entry的使用练习
 * 对应百度网盘里的 毕向东的 05-集合(Map-entrySet)这一课
 * @author Wei
 * @time 2016年10月2日 上午11:54:54
 */
public class MyEntrySetTest {
	public static void main(String[] args) {
		Map<String, String> map = UtilCollections.generateMap("made", "我", 13);
		/**
		 * 取出map的set,返回一个set,然后用set.iterator()获得迭代器，
		 * 然后迭代取出map中的数据
		 */
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		// 使用普通的迭代器从map中取值
		while (it.hasNext()) {
			String k = it.next();
			System.out.println("key.v:" + map.get(k));
		}

		/**
		 * 通过Map.Entry来取值 通过Map.entrySet()方法去除Map中的映射关系集合，
		 * 然后通过返回的泛型为Map.Entry类型的Set获取迭代器，同时获取到的
		 * 迭代器的泛型也是Map.Entry类型的(假如获取到Map.Entry的变量为e),
		 * 那么e.getKey()直接获取到map中的key,e
		 * .getValue()直接获取到map中的value
		 */
		Set<Map.Entry<String, String>> entry = map.entrySet();
		Iterator<Entry<String, String>> it4 = entry.iterator();
		while (it4.hasNext()) {
			Map.Entry<String, String> e = it4.next();
			String thekey = e.getKey();
			String thevalue = e.getValue();
			UtilPrint.printN("key: " + thekey + ", value: " + thevalue);
		}

		// while(it.hasNext()){
		// String v = it.next();
		// System.out.println("key.v:"+v);
		// }

		/*
		 * for(Iterator<String> it2 = set.iterator(); it2.hasNext();){ String
		 * nxt = it2.next(); System.out.println("it2.next:"+nxt); }
		 */
		UtilPrint.printN("--------------");
		System.out.println("set.size:" + set.size());
		UtilPrint.printWithSeparatorAndClass("-----------", MyEntrySetTest.class);
	}
}
