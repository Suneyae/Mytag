package com.log.service;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用于监听session的创建与销毁等,已经统计在线人数
 * 
 * @author Wei 下午10:08:23 2016-8-28
 */
public class WylSessionListener implements HttpSessionListener {
	private static int NUMBERS_ONLINE = 0;

	public WylSessionListener() {
		System.out.println("com.log.service.WylSessionListener()实例化，");
	}

	@Override
	public void sessionCreated(HttpSessionEvent seEvent) {
		String sessionId = seEvent.getSession().getId();
		NUMBERS_ONLINE++;
		System.out.println("WylSessionListener.sessionCreated()...,sessionId:" + sessionId+",在线人数："+NUMBERS_ONLINE);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent seEvent) {
		String sessionId = seEvent.getSession().getId();
		NUMBERS_ONLINE--;
		System.out.println("WylSessionListener.sessionDestroyed()...,sessionId:" + sessionId+",在线人数："+NUMBERS_ONLINE);
	}

}
