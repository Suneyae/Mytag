package com.test.javaAPI.strutssimulate.recursion;
/**
 * 测试递归
 * @author Wei
 * @time  2016年10月7日 下午12:05:40
 */
public class recursionTest {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.testA(b);
	}
}

class A {
	public int indexA = 0;

	public void testA(B b) {
		indexA++;
		System.out.println("indexA:" + indexA);
		if (indexA < 10) {
			b.testB(this);
		}

	}
}

class B {
	public int indexB = 0;

	public void testB(A a) {
		indexB++;
		System.out.println("indexB:" + indexB);
		if (indexB < 10) {
			a.testA(this);
		}

	}
}