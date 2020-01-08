package com.test.javaAPI.bitoperation;

/**
 * 移位操作的练习
 * 
 * @author Wei
 * @time 2016年10月2日 上午9:36:57
 */
public class ByteShift {
	public static void main(String[] args) {
		testXor();
	}

	/**
	 * 交换两个int
	 */
	public static void testXor() {
		int a = 10;
		int b = 233;
		a = a ^ b;// ab
		b = b ^ a;// bab也就是 bba ，所以是a
		a = a ^ b;// aabbb所以是b
		System.out.println("a:" + a + ",b:" + b);
	}

}
