package com.test.javaAPI.annotation;
/**
 * 测试使用我自己定义的注解wyl
 * @author Wei
 * @time  2017年4月10日 下午4:24:20
 */
public class AnnotationTest {

	public AnnotationTest() {
		
	}
	
	@Wyl(author="elegent", date = "20170410",version=13)
	public static void main(String[] args) {
		System.out.println("usring custom annotation ...");
	}
	
	
	
}
