package com.base.pattern.decorator;

/**
 * 
 * @author Wei
 * @time 2017年6月12日 下午2:51:34
 */
public class Source implements Sourceable {

	public Source() {

	}

	@Override
	public void method() {
		System.out.println("the original method!");
	}

}
