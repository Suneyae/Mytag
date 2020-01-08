package com.test.javaAPI.bitoperation;

/**
 * 异或的练习
 * 
 * @author Wei
 * @time 2016年10月1日 下午4:14:40
 */
public class Xor {
	public static void main(String[] args) {
		int a = 33;
		int b = 31;
		System.out.println(Integer.toBinaryString(a));
		System.out.println("0"+Integer.toBinaryString(b));
		System.out.println(a+"^"+b+":"+(a^b));
	}
	
	
	
}
