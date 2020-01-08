package com.test.javaAPI.enums;

/**
 * 枚举的使用
 * 
 * @author Wei
 * @time 2016年10月3日 下午5:06:04
 */
public class EnumTest2 {
	public static void main(String[] args) {
		new EnumTest2().printScore(MyEnum2.A);
		/** 
		 * 注意点1 ： MyEnum2.A就相当于普通的类中new 的一个实例对象，就像new XXX()这个对象
		 * 所以MyEnum2.A就可以理解为一个实例对象，因此就可以像普通的实例对象一样来使用
		 */
		
		System.out.println("MyEnum.B:"+MyEnum.B+"---,--MyEnum.B.name():"+MyEnum.B.name());
		System.out.println(MyEnum.B.getScore());
	}
	
	public void printScore(MyEnum2 e){
//		System.out.println();
	}
}

enum MyEnum2 {
	A("90-100"), B("80-89"), C("70-79");
	
	private String score;
	public static String score2;
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	private MyEnum2(String score) {
		this.score = score;
		//没用一次枚举，就会打印多次，System.out.println("我的score:" + score);
	}
	
	
}