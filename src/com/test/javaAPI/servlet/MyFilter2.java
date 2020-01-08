package com.test.javaAPI.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.util.UtilPrint;
/**
 * web应用的Filter的练习demo
 * @author Wei
 * @time  2016年10月4日 下午12:55:17
 */
public class MyFilter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		UtilPrint.printWithSeparatorAndClass("------init()方法", MyFilter2.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		UtilPrint.printWithSeparatorAndClass("------doFilter()方法begin了", MyFilter2.class);
		
		UtilPrint.printWithSeparatorAndClass("------doFilter()方法end了", MyFilter2.class);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		UtilPrint.printWithSeparatorAndClass("------destroy()方法", MyFilter2.class);
	}

}
