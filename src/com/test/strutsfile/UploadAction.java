package com.test.strutsfile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Wei
 * @time 2016年10月7日 下午10:07:48
 */
public class UploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String filename;
	
	private File java1234; // 文件
	
	private String java1234ContentType;  // 文件类型

	private String java1234FileName;  // 文件名
	@Override
	public String execute() throws Exception {
		System.out.println("UploadAction 开始上传文件了》。。。。。。。。。。。。。。。");
		System.out.println("文件名 filename："+filename);
		System.out.println("文件名 java1234FileName："+java1234FileName);
		System.out.println("文件类型："+java1234ContentType);
		String filePath="C:/Users/Wei/Desktop/"+java1234FileName;
		File saveFile=new File(filePath);
		FileUtils.copyFile(java1234, saveFile);
		return SUCCESS;
	}


	public String getFilename() {
		return filename;
	}


	public File getJava1234() {
		return java1234;
	}


	public String getJava1234ContentType() {
		return java1234ContentType;
	}

	public String getJava1234FileName() {
		return java1234FileName;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setJava1234(File java1234) {
		this.java1234 = java1234;
	}

	public void setJava1234ContentType(String java1234ContentType) {
		this.java1234ContentType = java1234ContentType;
	}

	public void setJava1234FileName(String java1234FileName) {
		this.java1234FileName = java1234FileName;
	}
	
}
