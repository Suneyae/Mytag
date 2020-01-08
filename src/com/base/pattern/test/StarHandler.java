package com.base.pattern.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.util.UtilTime;

/**
 * 通过实现 InvocationHandler接口以实现动态代理 就如静态代理一样， 不管是静态代理还是动态代理，都需要传入一个被代理类
 * 
 * @author Wei
 * @time 2016年9月27日 下午9:10:33
 */
public class StarHandler implements InvocationHandler {
	// 声明一个被代理类变量，用于接收构造器里传入的被代理对象
	RealStar realStar;

	/**
	 * 传入被代理类，
	 * 
	 * @param realStar
	 */
	public StarHandler(RealStar realStar) {
		this.realStar = realStar;
	}
	/**
	 * proxy ：不能调用 toString方法，否则会陷入死循环。
	 * method: 被代理类的方法，用于代码中使用反射
	 * args:   被代理类的method方法需要用的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 获取代理类的方法名
		String methodName = method.getName();
		System.out.println(UtilTime.getCurrentTime(null) + "将要真正执行代理的方法：" + methodName);
		// 固定的写法，调用被代理类的方法
		method.invoke(realStar, args);
		System.out.println(UtilTime.getCurrentTime(null) + "已经执行完代理的方法：" + methodName);
		System.out.println();
		return null;
	}

}
