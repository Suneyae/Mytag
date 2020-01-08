package com.base.pattern.singleton;

/**
 * 饿汉式单例模式
 * 
 * @author Wei
 * @time 2016年9月25日 下午10:33:16
 */
public class MySingleton2 {
	private static MySingleton2 instance = new MySingleton2();

	/**
	 * 私有化构造器，不允许进行new 实例
	 */
	private MySingleton2() {
	}

	public static synchronized MySingleton2 getInstance() {
		return instance;
	}
}
