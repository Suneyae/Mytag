package com.thread;
/**
 * ThreadLocal类的测试与使用
 * @author Wei
 * @time  2017年4月10日 下午1:27:19
 */
public class ThreadLocalTest implements Runnable {
	String name = null;
	int i = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (; i < 10; i++) {
			// synchronized (this) {
			// name = Thread.currentThread().getName();
			//
			// try {
			// Thread.sleep(10);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// System.out.println("i:" + i + ","
			// + Thread.currentThread().getName() + ":" + name);
			// }

			name = Thread.currentThread().getName();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i:" + i + ","
					+ Thread.currentThread().getName() + ":" + name);
		}
	}
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		/*ThreadLocalTest t = new ThreadLocalTest();
		Thread ta = new Thread(t, "AAA");
		Thread tb = new Thread(t, "CCC");
		ta.start();
		ta.interrupt();
		tb.start();*/
		/*try {
			ta.join();
			System.out.println("线程a调用了join方法");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ThreadLocal tl = new ThreadLocal<>();
		Object obj = tl.get();
		System.out.println(obj);
	}

}
