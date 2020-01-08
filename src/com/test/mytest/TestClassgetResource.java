package com.test.mytest;

import java.net.URL;

/**
 * 
 * 原文：http://www.cnblogs.com/yejg1212/p/3270152.html 
 * 测试class.getResource()的用法
 * Class.getResource(String path)
 * path不以’/'开头时，默认是从此类所在的包下取资源；
   path  以’/'开头时，则是从ClassPath根下获取；
 * @author Wei
 * @time 20160828
 */
public class TestClassgetResource {
	public static void main(String[] args) {
		URL url= TestClassgetResource.class.getResource("sysconfig.properties");
		System.out.println(TestClassgetResource.class.getResource(""));
		System.out.println("--------- url:"+url);
		System.out.println("\nurl:"+url.toString());
		System.out.println("\nurl:"+url);
	}
}
