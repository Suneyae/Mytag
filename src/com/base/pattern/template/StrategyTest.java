package com.base.pattern.template;
/**
 * 目标作用：就是在AbstractCalculator类中定义一个主方法calculate，calculate()调用spilt()等，
 * Plus和Minus分别继承AbstractCalculator类，通过对AbstractCalculator的调用实现对子类的调用，
 * 看下面的例子：
 * @author Wei
 * @time  2017年6月12日 下午3:34:00
 */
public class StrategyTest {

	public StrategyTest() {
	}
	
	public static void main(String[] args) {
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		System.out.println("result:"+result);
	}
}
