package com.log.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 测试session的属性的绑定
 * 
 * @author Wei
 * @time 2016年10月5日 下午9:38:14
 */
public class User6 implements HttpSessionBindingListener {
	public User6() {

	}

	private String userName;
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		/**
		 * event.getName()获取session的setAttribute的绑定的key，
		 */
		System.out.println("测试session的属性的绑定,com.log.entity.User6.valueBound(HttpSessionBindingEvent event)...." + event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("测试session的属性的绑定,com.log.entity.User6.valueUnbound(HttpSessionBindingEvent event) ...." + event.getName());
	}

}
