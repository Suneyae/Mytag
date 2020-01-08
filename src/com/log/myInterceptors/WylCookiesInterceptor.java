package com.log.myInterceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class WylCookiesInterceptor extends ActionSupport {
	@Override
	public String execute() throws Exception {
//		ServletActionContext.getContext()
		return SUCCESS;
	}
}
