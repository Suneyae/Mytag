package com.test.javaAPI.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyServlet2(){
		System.out.println("com.test.javaAPI.servlet.MyServlet2()构造器...");
	}
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("com.test.javaAPI.servlet.MyServlet2.init()方法....");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getOutputStream().write(("<strong style=\"color:orange;\">哈哈哈哈，我是com.test.javaAPI.servlet.MyServlet2.doGet()方法</strong>"+req.getRequestURI()).getBytes());
		System.out.println("req.getMethod():" + req.getMethod());
		System.out.println("req.getRequestURL():" + req.getRequestURL());
		System.out.println("req.getRequestURI():" + req.getRequestURI());
	}
}
