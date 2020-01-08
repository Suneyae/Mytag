package com.log.myInterceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.util.UtilStruts;
import com.util.UtilTime;

/**
 * 用于超时检查的拦截器
 * 
 * @author Wei 下午10:15:18 2016-8-28
 */
public class WylTimeOutInterceptor implements Interceptor {
	// 设置超时时间为5分钟
	long MAX_INTERVAL = 1000 * 60 * 5;
	// long MAX_INTERVAL = 1000 * 5;
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("WylTimeOutInterceptor.destroy()....");

	}

	@Override
	public void init() {
		System.out.println("WylTimeOutInterceptor.init()....");

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = UtilStruts.getSession();
		String mThread = Thread.currentThread().getName();
		System.out.println("WylTimeOutInterceptor.intercept的线程：" + mThread);
//		long lastTime = (Long) session.get("lastTime");
		Object obj = session.get("lastTime");
		if(obj==null){
			obj = Long.valueOf("0");
		}
		long lastTime = (Long)obj;
		long interval = UtilTime.getInterValTime(lastTime);
		String result = null;
		if (interval > MAX_INTERVAL) {
			session.put("timeout_msg", "您长时间未操作，已经超时...");
			result = "error";
		} else {
			result = invocation.invoke();
			session.put("lastTime", UtilTime.getCurTime());
		}
		return result;
	}
}
