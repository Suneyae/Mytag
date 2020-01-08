package com.base.pattern.staticproxy;

public class RealStar implements Star {
	public RealStar() {

	}

	@Override
	public void sing() {
		System.out.println("RealStar is singing");
	}

	@Override
	public void booktickets() {
		System.out.println("RealStar  booktickets");
	}

}
