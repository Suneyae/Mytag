package com.test.javaAPI;

/**
 * http://www.cnblogs.com/nerxious/archive/2013/01/24/2875649.html
 * 
 * @author Wei
 * @time 2016年9月16日 下午4:30:27 内部类的有点：从上面的例子不难看出，内部类其实严重破坏了良好的代码结构，但为什么还要使用内部类呢？
 * 
 *       因为内部类可以随意使用外部类的成员变量（包括私有）而不用生成外部类的对象，这也是内部类的唯一优点
 * 
 */
public class InnerClassTest {
	public static void main(String[] args) {
		/**
		 * 必须先有外部类的对象才能生成内部类的对象， 
		 * 因为内部类的作用就是为了访问外部类中的成员变量
		 */
		Out.In in = new Out().new In();
		in.print();
		
		
		/**
		 * 测试静态内部类
		 */
		Out.In2 in2 = new Out.In2();
		System.out.println("in2:"+in2.nameIn2);
	}
}

class Out {
	private int age = 12;
	private static String name = "weiyongle";
	class In {
		public void print() {
			System.out.println(age);
		}
	}
	/**
	 * 我是静态内部类In2.java
	 * @author Wei
	 * @time  2016年9月16日 下午5:06:44
	 */
	static class In2{
		protected String nameIn2 = name;
		public void print(){
			System.out.println(Out.name);
		}
	}
}
