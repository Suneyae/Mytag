package com.test.javaAPI;
/**
 * 异常的分类，对应于高淇300集的73课
 * Exception 分为：
 * 1 checked：没法通过编译的代码
 * 2 unchecked：编译通过的，但是会报错的代码
 * @author Wei
 * @time  2016年9月15日 下午10:06:17
 */
public class ExceptionTest {
	public static void main(String[] args) {
		try {
			//checked，Thread.sleep(1000);这行代码必须要捕获或者抛出异常，否则没法通过编译
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class xx {
	
}
