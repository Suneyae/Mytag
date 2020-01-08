package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 作用：加载IOC容器的公用类，实际上就是加载Spring配置文件
 * 
 * @author Wei
 *
 */
@Component
public class Pub2 implements ApplicationContextAware {
	public static ApplicationContext atx;
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("Pub2.setApplicationContext().....");
		this.atx = applicationContext;
	}
	
	/**
	 * 通过实现 ApplicationContextAware 接口获取 ApplicationContextAware
	 * @return
	 */
	public static ApplicationContext getContext(){  
        return atx;  
  }  
}
