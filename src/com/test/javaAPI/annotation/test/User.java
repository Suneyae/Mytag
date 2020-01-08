package com.test.javaAPI.annotation.test;

/**
 * 参考： http://www.cnblogs.com/liangweiping/p/3837332.html 第2步：在数据模型使用注解
 * 
 * @author Wei
 * @time 2017年4月10日 下午4:44:27
 */
public class User {

	private String name;
	private String age;
	private int height;
	
	
	public int getHeight() {
		return height;
	}
	@Init(valueInt=171)
	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	@Init
	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	@Init(value = "23")
	public void setAge(String age) {
		this.age = age;
	}

}
