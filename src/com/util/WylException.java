package com.util;

/**
 * 自定义异常
 * 
 * @author Wei
 * @time 2016年9月18日 下午9:30:45
 */
public class WylException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 空构造器
	 */
	public WylException() {

	}

	/**
	 * 
	 * @param msg
	 */
	public WylException(String msg) {
		System.out.println("WylException异常：" + msg);
	}

	@Override
	public void printStackTrace() {
		System.out.println("遇到WylException.printStackTrace()异常");
	}

	/**
	 * 无效的参数异常
	 */
	public void WylIllegalParamsException(String msg) {
		if(!UtilString.isNull(msg)){
			
		}
		System.out.println("遇到WylException.WylIllegalParamsException()无效参数异常");
	}

}
