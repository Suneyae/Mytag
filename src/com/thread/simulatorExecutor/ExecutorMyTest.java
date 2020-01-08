package com.thread.simulatorExecutor;
/**
 * 
 * @author Wei
 * @time  2017年4月5日 下午4:54:19
 */
public class ExecutorMyTest {

	public ExecutorMyTest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 没有成功模拟
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorServiceMyImpl executor = new ExecutorServiceMyImpl();
		executor.execute(new Runnable() {
			public void run() {
				System.out.println("所在线程:"+Thread.currentThread().getName());
			}
		});
	}
}
