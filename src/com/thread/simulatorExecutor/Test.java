package com.thread.simulatorExecutor;

import java.util.ArrayList;
/**
 * 
 * @author Wei
 * @time  2017年4月5日 下午5:30:36
 */
public class Test {

	public static void main(String[] args) {
		final InsertData insertData = new InsertData();

		new Thread() {
			public void run() {
				insertData.insert3(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				insertData.insert3(Thread.currentThread());
			};
		}.start();
	}
}

class InsertData {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	/*public synchronized void insert(Thread thread) {
		for (int i = 0; i < 5; i++) {
			System.out.println(thread.getName() + "在插入数据" + i);
			arrayList.add(i);
		}
		System.out.println("arrayList:"+arrayList.size()+"\n");
	}*/
	
	public void insert(Thread thread) {
		for (int i = 0; i < 5; i++) {
			System.out.println(thread.getName() + "在插入数据" + i);
			arrayList.add(i);
		}
		System.out.println("arrayList:"+arrayList.size()+"\n");
	}
	
	public void insert3(Thread thread){
		
		synchronized(this){
			System.out.println("长度"+this.arrayList.size()+",this:"+this.getClass());
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(thread.getName() + "在插入数据" + i);
			arrayList.add(i);
		}
		System.out.println("arrayList:"+arrayList.size()+"\n");
	}
	
}
