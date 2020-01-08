package com.test.javaAPI.collections;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet的使用练习，对应于尚学堂110课
 * @author Wei
 * @time  2016年10月1日 下午2:09:48
 */
public class HashSetTest {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		// part 1
		/*Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new String("aaa"));
		System.out.println(set.size());
		set.remove("aaa");
		System.out.println(set.size());*/
		
		
		// part 2
		test01();
		
	}
	/**
	 * 20170424 14:22 添加
	 */
	@SuppressWarnings("all")
	public static void test01(){
		Set set = new HashSet<>();
		set.add("wei");
		set.add("hhh");
		set.add(3241);
		set.add("wei");
		test02(set);
		test03(set);
	}
	
	
	@SuppressWarnings("all")
	public static void test02(Set set){
		for(Iterator iterator = set.iterator();iterator.hasNext();){
			System.out.printf("iterator : %s\n", iterator.next());
		}
		System.out.println("set.size():"+set.size());
		
		
		
	}
	
	@SuppressWarnings("all")
	public static void test03(Set set){
		HashSet s = (HashSet) set;
		HashSet s2 = (HashSet) s.clone();
		System.out.println("==========test03()===========");
		for(Iterator iterator = s2.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
		
		Object[] arr = s2.toArray();
		System.out.println("arr:"+arr);
	}
	
	
	
	
	
}
