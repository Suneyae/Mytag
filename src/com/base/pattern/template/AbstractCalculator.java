package com.base.pattern.template;

/**
 * 模板方法模式（Template Method）
 * 参考：http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * 
 * @author Wei
 * @time 2017年6月12日 下午3:17:49
 */
public abstract class AbstractCalculator {

	public AbstractCalculator() {
		
	}
	/**
	 * 主方法
	 * @param exp
	 * @param opt
	 * @return
	 */
	public final int calculate(String exp, String opt) {
		int arr[] = split(exp, opt);
		return calculate(arr[0], arr[1]);
	}

	abstract public int calculate(int num1, int num2);
	
	public int[] split(String exp, String opt) {
		String arrStr[] = exp.split(opt);
		int arrInt[] = new int[2];
		arrInt[0] = Integer.parseInt(arrStr[0]);
		arrInt[1] = Integer.parseInt(arrStr[1]);
		return arrInt;
	}
}
