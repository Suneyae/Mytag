package com.log.entity;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * servlet中的钝化与活化
 * @author Wei
 * @time  2016年10月5日 下午9:39:18
 */
public class User5 implements HttpSessionActivationListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User5() {

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
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("com.log.entity.User5.sessionWillPassivate(HttpSessionEvent se) 钝化....");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("com.log.entity.User5.sessionDidActivate(HttpSessionEvent se) 活化....");

	}

}
