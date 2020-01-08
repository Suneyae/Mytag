package com.base.pattern.decorator;

/**
 * 
 * @author Wei
 * @time 2017年6月12日 下午2:51:52
 */
public class DecoratorTest {

	public DecoratorTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}
}
