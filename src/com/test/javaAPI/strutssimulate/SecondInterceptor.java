package com.test.javaAPI.strutssimulate;
/**
 * 模拟struts2的第二个拦截器
 * @author Wei
 * @time  2016年10月7日 上午11:28:36
 */
public class SecondInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation invocation) {
		System.out.println("模拟拦截器 2 ");
		invocation.invoke();
		System.out.println("模拟拦截器 -2 ");
	}

}
