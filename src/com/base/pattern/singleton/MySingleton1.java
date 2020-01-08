package com.base.pattern.singleton;
/**
 * 懒汉式单例模式
 * @author Wei
 * @time  2016年9月25日 下午10:33:16
 */
public class MySingleton1 {
	private static MySingleton1 instance = null;

	/**
	 * 私有化构造器，不允许进行new 实例
	 */
	private MySingleton1() {
	}

	public static synchronized MySingleton1 getInstance() {
		if (instance == null) {
			instance = new MySingleton1();
		}
		return instance;
	}
}
