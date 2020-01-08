package com.thread;

public class ThreadTest extends Thread {

	public ThreadTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		t.start();
	}
}
