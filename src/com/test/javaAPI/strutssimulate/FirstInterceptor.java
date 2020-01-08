package com.test.javaAPI.strutssimulate;
/**
 * 模拟struts2的第一个拦截器
 * @author Wei
 * @time  2016年10月7日 上午11:28:36
 */
public class FirstInterceptor implements Interceptor {
	/**
	 * 传入action的代理对象，调用代理的invoke方法
	 */
	@Override
	public void intercept(ActionInvocation invocation) {
		System.out.println("模拟拦截器 1 ");
		invocation.invoke();
		System.out.println("模拟拦截器 -1 ");
	}

}
