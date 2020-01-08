package com.wyl.ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.util.UtilPrint;
import com.util.UtilTime;

public class MyAjaxImg extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream imageStream;


	// 用于wylAJax.js中的传参，
	private String parameters;

	@Override
	public String execute() throws Exception {
		new File("D:\\AA.txt");
		long curTime = UtilTime.getCurTime();
		UtilPrint.printN(curTime+"");
		imageStream = new FileInputStream(new File("C:\\Users\\Wei\\Desktop\\wx.jpg"));
		UtilPrint.printN("读取文件或者下载文件耗时："+UtilTime.getInterValTime(curTime));
		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public String getParameters() {
		return parameters;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
