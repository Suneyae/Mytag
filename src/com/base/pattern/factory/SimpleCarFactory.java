package com.base.pattern.factory;
/**
 * 简单工厂方法,也叫静态工厂方法
 * @author Wei
 * @time  2016年9月26日 下午9:34:58
 */
public class SimpleCarFactory {
	public static Car getCar(String carName) {
		if ("奥迪".equals(carName)) {
			return new Audi();
		} else if ("比亚迪".equals(carName)) {
			return new Byd();
		}
		return null;
	}
}
