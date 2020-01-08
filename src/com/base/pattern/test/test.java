package com.base.pattern.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 代理类测试
 * 
 * @author Wei
 * @time 2016年9月27日 下午10:08:08
 */
public class test {
	public static void main(String[] args) throws InterruptedException {

		RealStar realStar = new RealStar();
		ClassLoader loader = realStar.getClass().getClassLoader();
		Class<?>[] interfs = realStar.getClass().getInterfaces();
		// 传入被代理类，也就是真正的明星类
		InvocationHandler h = new StarHandler(realStar);
		// 生成代理类，这是至关重要的一步
		Star proxy = (Star) Proxy.newProxyInstance(loader, interfs, h);
		
		proxy.sing();
		Thread.sleep(1000);
		proxy.actMovie();
	}
	
	
	/*public static void main(String[] args) {
//		String[] array = { "CSV", "EXCEL", "PDF", "TEXT" };
		String[] array = { "PDF", "TEXT","EXCEL","CSV"};
		Arrays.sort(array);
		System.out.println(Arrays.asList(array));
	}*/
	
	
}
