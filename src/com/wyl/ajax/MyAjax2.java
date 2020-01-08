package com.wyl.ajax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.test.TestAction;
import com.util.Pub;
import com.util.Pub2;

public class MyAjax2 extends ActionSupport {
	{
		System.out.println("MyAjax2.......");
	}
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String tip;

	public InputStream getTip() {
		return new ByteArrayInputStream(tip.getBytes());
	}


	@Override
	public String execute() throws Exception {
		if(this.userName!=null||this.userName!=""){
			if(this.userName.equals("wyl")){
				this.tip = "<span style='color:red;font-family:verdana'>该用户已经注册</span>";
			}else{
				this.tip = "<span style='color:green;font-family:verdana'> 该用户还未注册，可以正常使用</span>";
			}
		}else{
			this.tip = "<span style='color:red;font-family:verdana'> 用户名不能为空，请重新录入</span>";
		}
		
//		TestAction t = (TestAction) Pub.getBeanCtx("beans-auto2.xml").getBean("testAction");
//		t.writeTest2();
		TestAction t = (TestAction) Pub2.getContext().getBean("testAction");
		
//		Method method = Class.class.getMethod("writeTest2", new Class[]{});
//		TestAction t2 = new TestAction();
//		method.invoke(t2, new Object[]{});
		t.writeTest2();
		
		System.out.println("开始检查");
		return SUCCESS;
	}
	
	public static void main(String[] args) {
		
		TestAction t2 = new TestAction();
		Class cls = t2.getClass();
		Method method;
		try {
			method = ((Class)cls).getMethod("writeTest2", new Class[] {});
			try {
				method.invoke(t2, new Object[]{});
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
