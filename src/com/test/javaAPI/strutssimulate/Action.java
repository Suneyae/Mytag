package com.test.javaAPI.strutssimulate;

/**
 * 模拟struts2的拦截器
 * 
 * @author Wei
 * @time 2016年10月7日 上午11:48:43
 */
public class Action extends ActionSupport {
	@Override
	public String execute() {
		System.out.println("Action执行完了");
		return super.execute();
	}
}
