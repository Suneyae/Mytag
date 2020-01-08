package com.log.service;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.util.UtilPrint;

/**
 * 对应慕课网 3-1，http://www.imooc.com/video/5658，
 *  ServletContextListener的主要用途： 
 * 1 定时器
 * 2 获取全局属性对象(设置全局属性对象)
 * 3 获取web.xml中的初始化参数
 * @author Wei
 * @time 2016年10月4日 下午8:38:37
 */
public class WylContextListener implements ServletContextListener {

	public WylContextListener() {
		System.out.println("com.log.service.WylContextListener()实例化,");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("com.log.service.WylContextListener.contextInitialized()...,");
		ServletContext sc = sce.getServletContext();
		/**
		 * 设置全局变量，然后再整个应用的生命周期里都可以获取到
		 */
		sc.setAttribute("theGlobalPara", "我是全局的属性对象，");
		Enumeration<String> initparaNames = sc.getInitParameterNames();
		if (initparaNames.hasMoreElements()) {
			String name = initparaNames.nextElement();
			/**
			 * 获取web.xml中的初始化参数，
			 * <context-param> 
			 * 		<param-name>ctxName</param-name>
			 * 		<param-value>我是ctx的值</param-value> 
			 * </context-param>
			 */
			String initValue = sc.getInitParameter(name);
			UtilPrint.printWithSeparatorAndClass("------name:" + name + ",initValue:" + initValue,
					WylContextListener.class);
		} else {
			UtilPrint.printWithSeparatorAndClass("com.log.service.WylContextListener.contextInitialized()...,没有获取到初始化参数", WylContextListener.class);
		}
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("com.log.service.WylContextListener.contextDestroyed()...,");
	}

}
