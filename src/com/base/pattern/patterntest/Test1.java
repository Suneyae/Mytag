package com.base.pattern.patterntest;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.base.pattern.factory.Car;
import com.base.pattern.factory.SimpleCarFactory;
import com.base.pattern.staticproxy.ProxyStar;
import com.base.pattern.staticproxy.RealStar;
import com.base.pattern.staticproxy.Star;

public class Test1 {
	public static void main(String[] args) {
		// MySingleton2 a = MySingleton2.getInstance();
		// MySingleton2 b = MySingleton2.getInstance();
		// System.out.println("a:"+a);
		// System.out.println("b:"+b);

		// MySingleton1 c = MySingleton1.getInstance();
		// MySingleton1 d = MySingleton1.getInstance();
		// System.out.println("c:"+c);
		// System.out.println("d:"+d);

		int count = 10;
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				public void run() {

				}
			}).start();
		}
	}

	@Test
	public void testFactory() {
		Car car = SimpleCarFactory.getCar("奥迪");
		car.run();
	}

	@Test
	public void testStaticProxy() {
		Star star = new ProxyStar(new RealStar());
		star.booktickets();
		star.sing();
	}
}
