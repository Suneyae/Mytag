package com.test.javaAPI.strutssimulate.recursion;

import java.util.Random;

/**
 * 测试递归
 * 
 * @author Wei
 * @time 2016年10月7日 下午12:05:40
 */
public class recursionTest2 {
	public static int index = 0;
	static String separator = "  ";

	public static void main(String[] args) {
		printA();
	}

	public static void printA() {
		index++;
		Random r = new Random();
		int ran = r.nextInt(100);
		String a = index + "-" + ran;
		separator += separator;
		String separatorb = separator;
		if (index < 5) {
			System.out.println(separator + "开始 A,index:" + a);
			printA();
			System.out.println(separatorb + "结束 A:index:" + a);
		}

	}
}
