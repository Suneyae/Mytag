package com.wyl.ajax;

import java.io.*;
import java.text.*;
import java.util.Date;

/**
 * 文件下载的 Action
 * 
 */
public class NetbookSerialAction {

	public String execute() throws Exception {
		// 这里可加入权限控制
		return "success";
	}

	// 获得下载文件的内容，可以直接读入一个物理文件或从数据库中获取内容
	public InputStream getInputStream() throws Exception {
		// return new FileInputStream("somefile.rar"); 直接下载 somefile.rar

		// 和 Servlet 中不一样，这里我们不需对输出的中文转码为 ISO8859-1
		return new ByteArrayInputStream("Struts2 文件下载测试".getBytes());
	}

	// 对于配置中的 ${fileName}, 获得下载保存时的文件名
	public String getFileName() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String fileName = "序列号(" + df.format(new Date()) + ").txt";
		try {
			// 中文文件名也是需要转码为 ISO8859-1，否则乱码
			return new String(fileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			return "impossible.txt";
		}
	}
}