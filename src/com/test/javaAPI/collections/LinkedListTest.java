package com.test.javaAPI.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 链表测试类，LinkedList
 * @author Wei
 * @time  2017年4月11日 上午10:01:54
 */
public class LinkedListTest {

	public LinkedListTest() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		int counts = 1000000;
		LinkedListTest0(counts);//1215
		ArrayListTest0(counts);// 44
	}
	
	@SuppressWarnings("all")
	private static void LinkedListTest0(int counts) {
		LinkedList<Object> list = new LinkedList<>();
		long begin = System.currentTimeMillis();
		
		for(int i=0;i<counts;i++){
//			list.add(i);
			list.add(i, i);
		}
		long end = System.currentTimeMillis();
		long time = end-begin;
		System.out.println("LinkedList:"+time);
	}
	
	@SuppressWarnings("all")
	private static void ArrayListTest0(int counts) {
		List<Object> list = new ArrayList<>();
		long begin = System.currentTimeMillis();
		
		for(int i=0;i<counts;i++){
//			list.add(i);
			list.add(i, i);
		}
		long end = System.currentTimeMillis();
		long time = end-begin;
		System.out.println("ArrayList:"+time);
	}
}
