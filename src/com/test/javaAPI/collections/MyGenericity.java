package com.test.javaAPI.collections;

import com.util.UtilPrint;

/**
 * 泛型测试
 * 
 * @author Wei
 * @time 2016年10月1日 下午6:19:28
 */
public class MyGenericity {
	public static void main(String[] args) {
		// GenericityTest<String> a = new GenericityTest<String>();
		GenericityTest<String> a = new GenericityTest<String>("卫永乐");
		System.out.println("name:" + a.getName());
		UtilPrint.printWithSeparator(null);
		UtilPrint.printWithSeparatorAndClass(null, MyGenericity.class);
		GenericityTest<Integer> b = new GenericityTest<Integer>(33);
		System.out.println("name:" + b.getName());
	}
}
