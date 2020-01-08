package com.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class UtilStruts {
	/**
	 * 获取struts2的session,实际上获取的是一个map类型的
	 * 
	 * @return
	 */
	public static Map<String, Object> getSession() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
}
