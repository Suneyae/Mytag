package com.log.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

public class WylSessionAttrbuteLister implements HttpSessionAttributeListener {
	
	private static final Logger mylogger = Logger
			.getLogger(WylSessionAttrbuteLister.class);
	private static Map<String, Object> ONLINEUSER = new HashMap<String, Object>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent sEvent) {
		HttpSession session = sEvent.getSession();
		Enumeration<?> attrNames = sEvent.getSession().getAttributeNames();
		// 如果从session获取到的属性枚举集合有元素，那么就循环
		while (attrNames.hasMoreElements()) {
			String key = (String) attrNames.nextElement();
			// 存放在线的用户
			ONLINEUSER.put(key, session.getAttribute(key));
			mylogger.info("WylSessionAttributeLister.attributeAdded(),"+session.getAttribute(key));
			System.out.println("WylSessionAttributeLister.attributeAdded(),"+session.getAttribute(key));
		}

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent sEvent) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent sEvent) {
		
	}

}
