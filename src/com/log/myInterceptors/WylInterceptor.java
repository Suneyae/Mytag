package com.log.myInterceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.log.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 拦截器，
 * 
 * @author Wei
 * @time 2016年9月16日 下午10:19:36
 */
public class WylInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("WylInterceptor.destory()...");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("WylInterceptor.init()...");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext atx = ActionContext.getContext();
		String mThread = Thread.currentThread().getName();
		System.out.println("WylInterceptor.intercept的线程：" + mThread);
		Map<String, Object> session = atx.getSession();
		// 对应于LoginAction.java 里的登录的时候设置的一个session对象
		User user = (User) session.get("currentUser");
		String result = null;
		System.out.println("WylInterceptor.intercept() before invoke ...");
		// 如果session里有currentUser，那么就放行
		if (user != null) {
			result = invocation.invoke();
			System.out.println("WylInterceptor.intercept() after invoke ...");
		} else {
			HttpServletRequest req = (HttpServletRequest) invocation.getInvocationContext()
					.get(ServletActionContext.HTTP_REQUEST);
			req.setAttribute("error_msg", "请先登录");
			System.out.println("WylInterceptor.intercept() 没有正常地 invoke ...");
			result = "error";
		}
		return result;
	}

}
