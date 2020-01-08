package com.test.javaAPI.synchronize;
/**
 * 测试同步锁的使用
 * @author Wei
 * @time  2017年3月21日 上午9:46:51
 */
public class SynchronizedTest {
	
	static int ALL_COUNTS = 1000;
	
	public SynchronizedTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static int sellTicket(int allcount,int num){
//		ALL_COUNTS = allcount;
		for(int i=0;i<num;i++){
			ALL_COUNTS -= 1;
		}
		return ALL_COUNTS;
	}
	
	public synchronized static int sellTicketSynchro(int allcount,int num){
//		ALL_COUNTS = allcount;
		for(int i=0;i<num;i++){
			ALL_COUNTS -= 1;
		}
		return ALL_COUNTS;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			Thread1 t1 = new Thread1();
			t1.start();
//			Thread2 t2 = new Thread2();
//			t2.run();
		}
	}
	
	
	public static class Thread1 extends Thread{
		@Override
		public void run() {
			int n1 = sellTicket(ALL_COUNTS, 1);
			System.out.println("所在线程:"+Thread.currentThread().getName()+",n1:"+n1);
		}
	}
	
	public static class Thread2 extends Thread{
		@Override
		public void run() {
			int n2 = sellTicket(ALL_COUNTS, 1);
			System.out.println("n2:"+n2);
		}
	}
}
