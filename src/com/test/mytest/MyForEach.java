package com.test.mytest;

import java.util.List;



import com.log.entity.RightObject;
import com.util.OperRight;

public class MyForEach {
	public StringBuilder getTreeMenus(List<RightObject> list) {
		for(RightObject obj :list){
			System.out.println("rightid:--------"+obj.getRightID());
			System.out.println(obj);
		}
		return null;
	}
	public static void main(String[] args) {
		OperRight ri = new OperRight();
//		List list = ri.getMenus("10001661");
		List list = ri.getMenus("10006116");
		new MyForEach().getTreeMenus(list);
	}
}
