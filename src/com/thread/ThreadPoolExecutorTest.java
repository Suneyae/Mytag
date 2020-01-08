package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 转自：http://cuisuqiang.iteye.com/blog/2019372 创建一个可缓存线程池，如果线程池长度超过处理需要，
 * 可灵活回收空闲线程，若无可回收，则新建线程
 * 
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 * 
 * @author Wei
 * @time 2016年11月7日 下午11:47:24
 */
public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		/*ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					String sb = Thread.currentThread().getName();
					System.out.println(index + "," + sb);
				}
			});
		}*/
		testThreadPool();
	}

	public static void testThreadPool() {
		/**
		 * 
			Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, 
			ThreadFactory, and Callable classes defined in this package. This class supports the following kinds of methods: 
			• Methods that create and return an ExecutorService set up with commonly useful configuration settings. 
			• Methods that create and return a ScheduledExecutorService set up with commonly useful configuration settings. 
			• Methods that create and return a "wrapped" ExecutorService, that disables reconfiguration by making 
			implementation-specific methods inaccessible. 
			• Methods that create and return a ThreadFactory that sets newly created threads to a known state. 
			• Methods that create and return a Callable out of other closure-like forms, so they can be used
			 in execution methods requiring Callable. 
			Since:1.5Author:Doug Lea
		 */
		ExecutorService executors = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			executors.execute(new Runnable() {
				@Override
				public void run() {
					String sb = Thread.currentThread().getName();
					System.out.println("first :ExecutorService"+index + "," + sb);
				}
			});
			/*pool.execute(new Runnable() {
				
				@Override
				public void run() {
					String sb = Thread.currentThread().getName();
					System.out.println("second:ExecutorService"+index + "," + sb);
				}
			});*/
			
		}
		executors.shutdown();//并不是终止线程的运行，而是禁止在这个Executor中添加新的任务  
		System.out.println("----------分割线-----------");
	}

}
