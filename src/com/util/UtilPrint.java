package com.util;

/**
 * System.out.println()方法的封装类，对一些打印内容进行格式化
 * 
 * @author Wei
 * @time 2016年10月1日 下午6:19:46
 */
public class UtilPrint {
	private static String NEWlINE = "\n";
	private static String DEFAULT_SEPARATOR = "--------分隔符--------";

	/**
	 * 标准化分隔符的打印，打印风格：2016.10.01 18:27:11 CST--------分隔符--------
	 * 
	 * @param separator
	 *            分隔符，如果不指定那么分隔符默认为：--------分隔符--------
	 */
	public static void printWithSeparator(String separator) {
		if (!UtilString.isNull(separator)) {
			DEFAULT_SEPARATOR = separator;
		}
		System.out.println(UtilTime.getCurrentTime(null) + DEFAULT_SEPARATOR);
	}

	/**
	 * 标准化分隔符的打印,打印格式如：2016.10.01 18:27:11
	 * CST,com.test.javaAPI.collections.MyGenericity--------分隔符--------
	 * 
	 * @param separator
	 *            分隔符，如果不指定那么分隔符默认为：--------分隔符--------
	 * @param clz
	 *            标准化打印格式的时候打印调用该方法所在的类的名称
	 */
	public static void printWithSeparatorAndClass(String separator, Class clz) {
		if (!UtilString.isNull(separator)) {
			DEFAULT_SEPARATOR = separator;
		}
		System.out.println(UtilTime.getCurrentTime(null) + "," + clz.getName() + DEFAULT_SEPARATOR);
	}

	/**
	 * 作用：自动换行打印
	 * 
	 * @param msg
	 */
	public static void printN(String msg) {
		System.out.println(NEWlINE + msg);
	}
}
