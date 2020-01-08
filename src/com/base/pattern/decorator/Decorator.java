package com.base.pattern.decorator;

/**
 * 
 * @author Wei
 * @time 2017年6月12日 下午2:51:46
 */
public class Decorator implements Sourceable {

	private Sourceable source;

	public Decorator(Sourceable source) {
		super();
		this.source = source;
	}

	@Override
	public void method() {
		System.out.println("before decorator!");
		source.method();
		System.out.println("after decorator!");

	}

}
