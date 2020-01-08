package com.base.pattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
	private Star realStar;// 真实角色

	/**
	 * 所有的流程控制都在invoke方法中 proxy：代理类 method：正在调用的方法 args：方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		if (proxy instanceof String) {

			String new_name = (String) proxy;
		} else {
			System.out.println("不是String类型");
		}

		System.out.println("真实角色调用之前的处理.....");
		if (method.getName().equals("sing")) {
			object = method.invoke(realStar, args);// 激活调用的方法
		}
		System.out.println("真实角色调用之后的处理.....");
		return object;
	}

	// 通过构造器来初始化真实角色
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}

}
