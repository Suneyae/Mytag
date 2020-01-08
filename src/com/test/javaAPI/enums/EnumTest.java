package com.test.javaAPI.enums;

/**
 * 枚举的使用
 * 
 * @author Wei
 * @time 2016年10月3日 下午5:06:04
 */
public class EnumTest {
	public static void main(String[] args) {
//		new EnumTest().printScore(MyEnum.A);
		System.out.println("MyEnum.B:"+MyEnum.B+"-----MyEnum.B.name():"+MyEnum.B.name());
		System.out.println(MyEnum.B.getScore());
	}
	
	public void printScore(MyEnum e){
//		System.out.println();
	}
}

enum MyEnum {
	A("90-100"), B("80-89"), C("70-79");
	public String score;

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	private MyEnum(String score) {
		this.score = score;
		//没用一次枚举，就会打印多次，System.out.println("我的score:" + score);
	}
}