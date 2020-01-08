package com.thread.simulatorExecutor;
/**
 * 模拟ExecutorService
 * @author Wei
 * @time  2017年4月5日 下午4:42:59
 */
public interface ExecutorServiceMy extends ExecutorMy{
	public void print(Object obj);
	public ExecutorServiceMy getInstance();
}
