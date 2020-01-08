package com.test.javaAPI.collections;

/**
 * 泛型的声明
 * 
 * @author Wei
 * @time 2016年10月1日 下午6:08:00
 * @param <T>
 */
public class GenericityTest<T> {

	public GenericityTest() {
		// TODO Auto-generated constructor stub
	}

	public GenericityTest(T name) {
		this.name = name;
	}

	private T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

}
