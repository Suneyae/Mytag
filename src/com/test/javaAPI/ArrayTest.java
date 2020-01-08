package com.test.javaAPI;

import java.util.Arrays;
/**
 * 测试 java.util.Arrays.copyOf(String[] original, int newLength)方法
 * @author Wei
 * @time  2016年9月15日 下午9:28:22
 */
public class ArrayTest {
	public static void main(String[] args) {
		String[] arr = {"abc","weiyongle"};
		System.out.println("复制之前的长度："+arr.length);
		arr = Arrays.copyOf(arr, 3);
		System.out.println("复制之后的长度："+arr.length);
		arr = Arrays.copyOf(arr, 33);
		System.out.println("复制之后的长度："+arr.length);
	}
}
