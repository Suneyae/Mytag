package com.test.javaAPI.string;

import org.junit.Test;

/**
 * String的测试类
 * 
 * @author Wei
 * @time 2016年9月28日 下午4:49:04
 */
public class StringTest {
	public static void main(String[] args) {

	}

	/**
	 * String.charAt(int index)
	 */
	@Test
	public void testCharAt() {
		String x = "abcdef";
		// x = "String重要方法";
		System.out.println(x.length());
		for (int i = 0; i < x.length(); i++) {
			System.out.println(i + "," + x.charAt(i) + ",");
		}
	}

	/**
	 * 测试String.indexOf(String str);
	 */
	@Test
	public void testindexOf() {
		String x = "abcdef为用饿了";
		for (int i = 0; i < x.length(); i++) {
			System.out.println(i + "," + x.charAt(i) + ",");
		}
		System.out.println("String.indexOf(string str)" + x.indexOf("ef为"));
		System.out.println("String ABC EF abcde ".indexOf("abcd"));
	}

	/**
	 * 测试String.testlastindexOf(String str);
	 */
	@Test
	public void testlastindexOf() {
		String x = "abcdef为用饿了ef";
		for (int i = 0; i < x.length(); i++) {
			System.out.println(i + "," + x.charAt(i) + ",");
		}
		System.out.println(x.indexOf("ef"));
		System.out.println("String.lastIndexOf(string str)" + x.lastIndexOf("ef"));
	}

	/**
	 * 测试String.testsubstring(String str);
	 * 
	 * "unhappy".substring(2) returns "happy" "Harbison".substring(3) returns
	 * "bison" "emptiness".substring(9) returns "" (an empty string)
	 */
	@Test
	public void testsubstring() {
		String x = "abcdef为用饿了ef";
		for (int i = 0; i < x.length(); i++) {
			System.out.println(i + "," + x.charAt(i) + ",");
		}
		System.out.println("String.substring(string str) " + x.substring(11));
	}

	/**
	 * 从字符串中某个字符开始截取
	 */
	@Test
	public void testsubstring2() {
		String x = "abcdef为用饿了ef";
		System.out.println("String.substring(string str) " + x.substring(11));
	}

	@Test
	public void testmysub() {
		/*
		 * String target = "abcdexxxJif"; String begin = "xxx";
		 */

		String begin = "abcdexxxJif";
		String target = "xxx";
		target = "abcdexxxJixxxxxxx";
		String rtn = getFirstCharFrom(target, begin);
		if ("".equals(rtn)) {
			System.out.println("没有相同的字符");
		}
		System.out.println("截取值：" + getFirstCharFrom(target, begin) + ",");
	}

	/**
	 * 从目标字符串target里开始从字符串begin开始截取 例子： String target = "abcde卫永乐Jif"; String
	 * begin = "卫永乐"; 返回 卫永乐Jif,如果在target中不包含begin，那么就返回空字符串""
	 * 
	 * @param target
	 * @param begin
	 * @return
	 */
	public static String getFirstCharFrom(String target, String begin) {
		String tmp;
		// 如果target的长度长于begin，那么调换
		if (target.length() < begin.length()) {
			tmp = target;
			target = begin;
			begin = tmp;
			tmp = "";
		}
		int theBegin = target.indexOf(begin);
		// 如果没有查询得到，那么就返回空字符串 ""
		if (theBegin < 0) {
			return "";
		} else {
			tmp = target.substring(theBegin);
		}
		return tmp;
	}

	@Test
	public void testsubstr2() {
		String a = "xxx;你大爷yz";
		int index = a.indexOf("yz");
		System.out.println("index:" + index);
		System.out.println(a.substring(0, a.indexOf("yz")));
		/*
		 * index:7 xxx;你大爷
		 */
	}

	/**
	 * 嘻嘻嘻;xxx
	 * 
	 * @param target
	 * @param begin
	 * @return
	 */
	public static String getFirstCharFrom2(String target, String begin) {
		String tmp = "";
		// 如果target的长度长于begin，那么调换
		if (target.length() < begin.length()) {
			tmp = target;
			target = begin;
			begin = tmp;
			tmp = "";
		}

		return tmp;
	}

	/**
	 * StringBuffer测试
	 */
	public void testStringBuffer() {
		String a = "xxx";
		StringBuilder b = new StringBuilder("bbb");
		System.out.println(a.length() + ",b.length():" + b.length());
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			throw new ArithmeticException("计算时出错");
		}
	}

	/**
	 * String.substring(int beginIndex, int endIndex) 
	 * Examples:
	 * 
	 * "hamburger".substring(4, 8)  returns "urge" 
	 * "smiles".substring(1, 5)     returns "mile"
	 * 
	 * substring(int begin,int end)指的是从位置begin 开始(包含index=begin这个字符)，
	 */
	@Test
	public void testsub2() {
		String aa = "abcdef9lkdjfij";

		String bb = aa.substring(aa.length() - 2);

		System.out.println("bb:" + bb);// bb:ij

		int index_first_f = aa.indexOf("f");

		System.out.println(aa.substring(index_first_f, index_first_f + 2));// f9

		System.out.println(aa.substring(aa.indexOf("9")));// 9lkdjfij

		System.out.println(aa.substring(1));// bcdef9lkdjfij

		System.out.println("aa.substring(aa.length()):" + aa.substring(aa.length()));// aa.substring(aa.length()):
	}

}
