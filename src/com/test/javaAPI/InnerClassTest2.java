package com.test.javaAPI;
/**
 * 
 * @author Wei
 * @time  2017年4月24日 下午5:20:48
 */
public class InnerClassTest2 {

	public InnerClassTest2() {
		// TODO Auto-generated constructor stub
	}
	public void test(Bird bird){
		int len = bird.fly();
		System.out.println("bird飞行了"+len+"米");
	}
	
	public static void main(String[] args) {
		InnerClassTest2 test2 = new InnerClassTest2();
		test2.test(null);
	}

	/**
	 * Bird类
	 * @author Wei
	 * @time  2017年4月24日 下午5:19:13
	 */
	public abstract class Bird{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * 飞行距离
		 * @return
		 */
		public abstract int fly();
		
	}
}


