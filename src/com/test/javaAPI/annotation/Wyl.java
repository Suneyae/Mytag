package com.test.javaAPI.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 自定义注解的demo
 * 
 * @author Wei
 * @time 2017年4月10日 下午4:15:13
 * @Target 元注解
 */
@Target(ElementType.METHOD)
public @interface Wyl {
	/**
	 * 1 注解类型是通过”@interface“关键字定义的;
	 * 
	 * 2 在”注解体“中，所有的方法均没有方法体且只允许public和abstract这两种
	 * 修饰符号（不加修饰符缺省为public），注解方法不允许有throws子句;
	 * 
	 * 3 注解方法的返回值只能为以下几种：原始数据类型）, String, Class, 
	 * 枚举类型, 注解和它们的一维数组，可以为方法指定默认返回值。
	 */
	String author() default "weiyongle";

	String date();

	int version() default 1;
}
