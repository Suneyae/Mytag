package com.test.javaAPI.annotation.test;

import java.lang.reflect.InvocationTargetException;

/**
 * 参考： http://www.cnblogs.com/liangweiping/p/3837332.html 第4步：运行的代码
 * 第4步：运行的代码
 * @author Wei
 * @time 2017年4月10日 下午4:45:51
 */
public class Test {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User user = UserFactory.create();
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.getHeight());
	}

}
