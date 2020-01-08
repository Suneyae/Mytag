package com.test.javaAPI.strutssimulate;

/**
 * 模拟struts2中的拦截器接口
 * 
 * @author Wei
 * @time 2016年10月7日 上午11:24:54
 */
public interface Interceptor {
	/**
	 * 模拟的拦截器，拦截器
	 * @param invocation
	 */
	public void intercept(ActionInvocation invocation);
}
