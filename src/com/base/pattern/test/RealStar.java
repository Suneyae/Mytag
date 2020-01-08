package com.base.pattern.test;

/**
 * 真实类，需要被代理的类
 * 
 * @author Wei
 * @time 2016年9月27日 下午9:09:16
 */
public class RealStar implements Star {

	@Override
	public void actMovie() {
		System.out.println("RealStar actMovie");
	}

	@Override
	public void sing() {
		System.out.println("RealStar sing a song");
	}

}
