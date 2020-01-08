package com.test.javaAPI.collections;

import java.util.ArrayList;
import java.util.List;

import com.util.WylException;

/**
 * 我的数组,模拟实现ArrayList
 * 
 * @author Wei
 * @time 2016年10月2日 下午2:49:40
 */
public class MyArrayList {

	private Object[] elementsData;

	public MyArrayList() {
		
	}

	public MyArrayList(int initialCapcity) throws WylException {
		if (initialCapcity >= 1) {
			this.elementsData = new Object[initialCapcity];
		} else {
			throw new WylException(null);
		}

	}

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();

		List list2 = new ArrayList<>(-4);

		/**
		 * throw new IllegalArgumentException("Illegal Capacity: "+
		 * initialCapacity);
		 */

	}
}
