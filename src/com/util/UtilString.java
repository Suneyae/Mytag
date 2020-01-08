package com.util;

/**
 * 我的字符串工具类
 * 
 * @author Wei
 * @time 2016年9月28日 下午4:39:19
 */
public class UtilString {
	/**
	 * 无参构造器，不允许外界实例化
	 */
	private UtilString() {

	}

	/**
	 * 从目标字符串target里开始从字符串begin开始截取 例子： String target = "abcde卫永乐Jif"; String
	 * begin = "卫永乐"; 返回 "卫永乐Jif",如果在target中不包含begin，那么就返回空字符串""
	 * 
	 * @param target
	 *            目标字符串，即需要被截取的字符串
	 * @param begin
	 *            需要从目标字符串中开始截取的第一段字符串
	 * @return 返回从目标字符串中截取的以 begin字符串开始的字符串
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

	/**
	 * 判断是否为空null或者""
	 * 
	 * @param charactor
	 * @return
	 */
	public static boolean isNull(String charactor) {
		if (null == charactor || "".equals(charactor)) {
			return true;
		}
		return false;
	}
	
}
