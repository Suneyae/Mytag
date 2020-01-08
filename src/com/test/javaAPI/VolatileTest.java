package com.test.javaAPI;
/**
 * 并发编程
 * 参考：http://www.cnblogs.com/dolphin0520/p/3920373.html
 * @author Wei
 * @time  2017年4月10日 下午5:41:10
 */
public class VolatileTest {

	public VolatileTest() {
		// TODO Auto-generated constructor stub
	}

	public volatile int inc = 0;
	
	public void increase() {
		inc++;
	}
	
	/*public synchronized void increase() {
		inc++;
	}*/
	
	public static void main(String[] args) {
		final VolatileTest test = new VolatileTest();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();
		System.out.println(test.inc);//7615 每次执行后的值都是不一样的，且值肯定小于10000
	}

}
