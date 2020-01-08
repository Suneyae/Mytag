package com.test.javaAPI;

import org.junit.Test;
/**
 * 测试自动拆装箱
 * @author Wei
 * @time  2016年9月17日 上午10:24:52
 */
public class AutoBoxingTest {
	
	
	@Test
	public void test1() {
		/**
		 * 自动装箱：基本数据类型 自动转换成Integer引用类型,如
		 * Integer a = 14;
		 * 本质上 编译器做了 Integer a = new Integer(14);
		 * 但是注意点：在[-128,127](包含-128和127)之间的数不会帮我们做装箱，还是作为
		 * 基本数据类型处理，详见：300集64课11分的视频
		 * 
		 */
		Integer a = 14;
		System.out.println(a.longValue());
		
		/**
		 * 自动拆箱：包装类对象自动转换成基本数据类型，如
		 * int b = new Integer(56);
		 * 实际上编译器做的是：
		 * int b = new Integer(56).intValue();
		 */
		int b = new Integer(56);
		System.out.println("自动拆箱后的数据："+b);
		
		/**
		 * Integer.toHexString(int i) 把一个int数据转换成 16进制 String字符串;
		 */
		String hexStr =Integer.toHexString(a);
		System.out.println("hexStr:"+hexStr);
		
		/**
		 * Integer.valueOf("234")这个方法会调用：public static Integer valueOf(int i){}
		 * 这个方法，Integer valueOf(int i){}这个方法会新建一个Integer对象
		 */
		Integer.valueOf("234").intValue();
		
		/**
		 * 
		 */
		Integer m = 3;
		Integer n = 3;
		System.out.println(m==n);
		
	}

	public static void main(String[] args) {
//		Integer b = null;
//		@SuppressWarnings("null")
//		int c = b+1;
//		System.out.println(c);
		/**
		 * 
		 */
		Integer m = -128;
		Integer n = -128;
		System.out.println(m==n);
		
		
		/**
		 * 
		 */
		Integer o = -129;
		Integer p = -129;
		System.out.println(o==p);
	}
}
