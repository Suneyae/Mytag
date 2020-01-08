package com.test.javaAPI.finalandstatic;

/**
 * 
 * @author Wei
 * @time 2016年11月8日 上午12:09:36
 */
public class Test4 {
	public static void main(String[] args) {
		new Test4().f1(2);
		new Test4().f1(0);
	}

	public void f1(final int i) {
//		i++;//The final local variable i cannot be assigned. It must be blank and not using a compound assignment
		// i++; //i是final类型的,值不允许改变的.
		System.out.println(i);
	}
}
