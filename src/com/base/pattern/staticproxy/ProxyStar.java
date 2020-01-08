package com.base.pattern.staticproxy;

public class ProxyStar implements Star {
	RealStar star;

	public ProxyStar(RealStar star) {
		this.star = star;
	}

	@Override
	public void sing() {
		star.sing();
	}

	@Override
	public void booktickets() {
		System.out.println("ProxyStar booktickets");
	}

}
