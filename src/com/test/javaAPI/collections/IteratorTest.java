package com.test.javaAPI.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.util.UtilCollections;
import com.util.UtilPrint;

/**
 * 迭代器的使用练习 对应 尚学堂 114课
 * 
 * @author Wei
 * @time 2016年10月1日 下午5:19:04
 */
public class IteratorTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("wei");
		set.add("yong");
		set.add("le");
		set.add("yong");
		Iterator<String> it = set.iterator();
		System.out.println("set.size():" + set.size());
		// 第一种写法
		while (it.hasNext()) {
			String obj = (String) it.next();
			System.out.println(obj);
		}
		System.out.println("-------分隔符-------");
		// 第二种写法
		for (Iterator<String> it2 = set.iterator(); it2.hasNext();) {
			String obj = (String) it2.next();
			System.out.println(obj);
		}
	}

}
