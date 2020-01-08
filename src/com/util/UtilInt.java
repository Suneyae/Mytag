package com.util;

/**
 * int类型数据的常用工具类
 * 
 * @author Wei
 * @time 2016年10月2日 上午9:43:49
 */
public class UtilInt {
	private UtilInt() {

	}
	/**
	 * 异或的操作，实际上只要记住2点就是：
	 * 1  两个数相同那么他们进行异或操作的话就是0，
	 * 2 0跟任何数字(比如这个数字为AA)进行异或就等于AA
	 * @param a
	 * @param b
	 */
	public static void exchangeData(Integer a, Integer b) {
		System.out.println("exchangeData.hashCode1 : :"+new Integer(a).hashCode());
		a = a ^ b;// ab
		b = a ^ b;// abb
		a = a ^ b;// bbaab
		System.out.println("exchangeData... a:" + a + ",b:" + b);
		System.out.println("exchangeData.hashCode2: :"+new Integer(a).hashCode());
	}

	public static void main(String[] args) {
		int a ;
		int b ;
		a = 10;
		b = 99;
		System.out.println("main.hashCode:"+new Integer(a).hashCode());
		exchangeData(a, b);
		System.out.println("a:" + a + ",b:" + b);
	}
	
	
}
