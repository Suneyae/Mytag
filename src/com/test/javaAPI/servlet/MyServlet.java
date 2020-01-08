package com.test.javaAPI.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	public MyServlet(){
		System.out.println("com.test.javaAPI.servlet.MyServlet()构造器...");
	}
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("com.test.javaAPI.servlet.MyServlet.init()方法....");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		/**
		 * resp.getWriter()和resp.getOutputStream()方法不能同时使用，
		 * 否则会抛出异常
		 * java.lang.IllegalStateException:
		 *  getWriter() has already been called for this response
		 */
//		resp.getWriter().write("xxxxxxxxxxxx");
		resp.getOutputStream().write(("哈哈哈哈，我是com.test.javaAPI.servlet.MyServlet.doGet()方法"+req.getRequestURI()).getBytes());
		System.out.println("req.getMethod():" + req.getMethod());
		System.out.println("req.getRequestURL():" + req.getRequestURL());
		System.out.println("req.getRequestURI():" + req.getRequestURI());
	}
}
