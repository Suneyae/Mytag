package com.log;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

/**
 * 1、使用Struts2 Aware拦截器
 * 需要Action类实现相应的拦截器接口。如我们要获得HttpServletResponse对象，需要实现org.apache.struts2.
 * interceptor.ServletResponseAware接口MyAction实现了一个ServletResponseAware接口，
 * 并且实现了setServletResponse方法。如果一个动作类实现了ServletResponseAware接口，
 * Struts2在调用execute方法之前，就会先调用setServletResponse方法，并将response参数传入这个方法。
 * 如果想获得HttpServletRequest、HttpSession和Cookie等对象，动作类可以分别实现ServletRequestAware、
 * SessionAware和CookiesAware等接口。这些接口都在org.apache.struts2.interceptor包中。
 * 如果要获得请求参数，动作类可以实现org.apache.struts2.interceptor.
 * ParameterAware接口，但如果只想判断某个参数是否存在，也可以实现com.opensymphony.xwork2.interceptor.
 * ParameterNameAware接口。这个接口有一个acceptableParameterName方法，当Struts2获得一个请求参数时，
 * 就会调用一次。读者可以在这个方法中将所有的请求参数记录下来，以便以后使用。这个方法的定义如下： boolean
 * acceptableParameterName(String parameterName)
 * 
 * @author Wei
 * @time 2016年10月5日 下午5:20:15
 */
class MyAction extends ActionSupport implements ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.servlet.http.HttpServletResponse response;

	// 获得HttpServletResponse对象
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String execute() throws Exception {
		response.getWriter().write("实现ServletResponseAware接口");
		return null;
	}
}

/*
 * 使用RequestAware拦截器
 * 和第1种方法类似。动作类需要实现一个org.apache.struts2.interceptor.RequestAware接口。
 * 所不同的是RequestAware将获得一个com.opensymphony.xwork2.util.OgnlValueStack对象，
 * 这个对象可以获得response、request及其他的一些信息
 */
class FirstAction extends ActionSupport implements RequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map request;
	private HttpServletResponse response;

	@Override
	public void setRequest(Map request) {
		this.request = request;
	}

	public String execute() throws Exception {
		java.util.Set<String> keys = request.keySet();
		// 枚举所有的key值。实际上只有一个key：struts.valueStack
		for (String key : keys)
			System.out.println(key);
		// 获得OgnlValueStack 对象
		OgnlValueStack stack = (OgnlValueStack) request.get("struts.valueStack");
		// 获得HttpServletResponse对象
		response = (HttpServletResponse) stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
		response.getWriter().write("实现RequestAware 接口");
		return null;
	}
}

/**
 * struts2中获取HttpServletrequest,HttpServletresponse,HttpSession的四种方式
 * 
 * @author Wei
 * @time 2016年10月5日 下午5:23:02
 */
public class LoginAction333 {
	public static void main(String[] args) throws IOException {

	}

	public void method3() {
		/*
		 * 3、使用ActionContext类，这个很方便
		 * 我们可以通过org.apache.struts2.ActionContext类的get方法获得相应的对象。代码如下：
		 */
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	}

	public void method4() throws IOException {
		/*
		 * 4、最简单的一种，使用ServletActionContext类
		 * Struts2为我们提供了一种最简单的方法获得HttpServletResponse及其他对象。这就是org.apache.struts2
		 * .ServletActionContext类。我们可以直接使用ServletActionContext类的getRequest、
		 * getResponse方法来获得HttpServletRequest、HttpServletResponse对象。
		 */
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		response.getWriter().write("hello world");
	}
}
