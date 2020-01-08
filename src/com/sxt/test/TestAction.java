package com.sxt.test;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

@Component
public class TestAction extends ActionSupport {
	
	public String companyName="尚学堂";
	
	public String execute() throws Exception {
		System.out.println("TestAction.execute()");
		return SUCCESS;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public static void writeTest(){
		System.out.println("----------");
	}
	
	public  void writeTest2(){
		System.out.println("----------");
	}
	
}
