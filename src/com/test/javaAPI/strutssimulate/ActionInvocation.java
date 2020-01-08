package com.test.javaAPI.strutssimulate;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟struts2的ActionProxy的实例actionInvocation
 * 
 * @author Wei
 * @time 2016年10月7日 上午11:48:34
 */
public class ActionInvocation {
	List<Interceptor> interceptors = new ArrayList<Interceptor>();
	int index = -1;
	/**
	 * 传入action，用来执行execute()方法
	 */
	Action action = new Action();

	public ActionInvocation() {
		this.interceptors.add(new FirstInterceptor());
		this.interceptors.add(new SecondInterceptor());
	}
	/**
	 * 调用action的execute()方法
	 */
	public void invoke() {
		index++;
		if (index >= this.interceptors.size()) {
			action.execute();
		} else {
			this.interceptors.get(index).intercept(this);
		}
	}
}
