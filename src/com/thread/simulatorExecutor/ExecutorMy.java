package com.thread.simulatorExecutor;
/**
 * 
 * @author Wei
 * @time  2017年4月5日 下午5:30:50
 */
public interface ExecutorMy {
	/**
	 * 需要传入一个Runnable实例
	 * @param runable
	 */
	public void execute(Runnable runable);
}
