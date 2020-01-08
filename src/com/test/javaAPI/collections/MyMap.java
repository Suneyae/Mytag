package com.test.javaAPI.collections;

import java.util.HashMap;
import java.util.Map;

import com.util.UtilTime;

/**
 * 自己实现Map
 * 
 * @author Wei
 * @time 2016年10月1日 上午9:49:33
 */
public class MyMap {
	MySet[] set = new MySet[400];
	int size = 0;

	public void put(Object key, Object value) {
		set[size++] = new MySet(key, value);
		// 如果数组的最大位置不为空，那么就进行扩容
		if (set[set.length - 1] != null) {
			// 在原来的基础上扩400，时间差不多为 10-12秒
			// 在原来的基础上扩100，时间差不多为 7-8秒
			// 在原来的基础上扩20，时间差不多为 5-6秒
			MySet[] set_ = new MySet[set.length + 20];
			// 在原来的基础上扩一倍,如果放入40000条数据，时间差不多15-17秒
			// MySet[] set_ = new MySet[set.length*2];
			for (int i = 0; i < set.length; i++) {
				set_[i] = set[i];
			}
			set = set_;
			set_ = null;
		}
	}

	/**
	 * 根据key来获取对应的value
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		for (int i = 0; i < size; i++) {
			if (set[i].key.equals(key)) {
				return set[i].value;
			}
		}
		return null;
	}

	/**
	 * 是否包含key
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++) {
			if (set[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 测试插入40000条数据需要花费的时间
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long beginTime = UtilTime.getCurTime();
		MyMap map = new MyMap();
		for (int i = 0; i < 40000; i++) {
			map.put(i, "wei" + i);
			System.out.println(map.get(i));
		}
		System.out.println(map.set.length);
		System.out.println("执行时间间隔为：" + UtilTime.getInterValTime(beginTime));

		System.out.println("是否包含key为4000:" + map.containsKey(4000));

	}

	/**
	 * 测试40000条数据只要290毫秒，0.3秒左右
	 */
	public void testprotoMap() {
		long beginTime = UtilTime.getCurTime();
		Map map = new HashMap();
		for (int i = 0; i < 40000; i++) {
			map.put(i, "wei" + i);
			System.out.println(map.get(i));
		}
		System.out.println("执行时间间隔为：" + UtilTime.getInterValTime(beginTime));

	}

}

class MySet {
	Object key;
	Object value;

	public MySet(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
}
