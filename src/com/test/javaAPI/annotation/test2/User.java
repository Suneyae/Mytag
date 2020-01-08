package com.test.javaAPI.annotation.test2;

/**
 * 参考： http://www.cnblogs.com/liangweiping/p/3837332.html 第2步：在数据模型使用注解
 * 
 * @author Wei
 * @time 2017年4月10日 下午4:44:27
 */
public class User {

	@Validate(min = 2, max = 5)
	private String name;

	@Validate(isNotNull = false)
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
