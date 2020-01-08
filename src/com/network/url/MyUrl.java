package com.network.url;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

/**
 * 网络编程的类
 * 
 * @author Wei
 * @time 2016年9月28日 下午4:49:27
 */
public class MyUrl {
	public static void xxx(String[] args) throws IOException {
		String url_str = "http://www.cnblogs.com/Sunnor/p/5914534.html";
		url_str = "http://www.cnblogs.com/Sunnor/p/5914534.html";
		// conn.getPermission():("java.net.SocketPermission"
		// "www.cnblogs.com:80" "connect,resolve")
		url_str = "http://www.cnblogs.com/Sunnor/p/5914534.html";
		// conn.getPermission():("java.net.SocketPermission" "www.zhihu.com:80"
		// "connect,resolve")
		url_str = "https://www.zhihu.com/";
		// Creates a URL object from the String representation.
		URL url = new URL(url_str);
		/*
		 * Object obj = url.getContent(); System.out.println(obj);
		 * System.out.println("getPort:" + url.getPort());
		 * System.out.println("getPath:" + url.getPath());
		 * System.out.println("getUserInfo:" + url.getUserInfo()); // 2 url获取输入流
		 * InputStream ips = url.openStream(); byte[] flush = new byte[1024];
		 * int len = 0; while (-1 != (len = ips.read(flush))) {
		 * System.out.println(new String(flush, 0, len)); } ips.close();
		 */
		// Returns a URLConnection instance that represents a connection to the
		// remote object referred to by the URL.
		URLConnection conn = url.openConnection();
		// Retrieves the contents of this URL connection.
		Object content = conn.getContent();
		// conn.get
		conn.getPermission();
		conn.getDoInput();
		String contentType = conn.getContentType();
		int contentLen = conn.getContentLength();
		System.out.println("content:" + content + ",");
		System.out.println("contentType:" + contentType + ",");
		System.out.println("contentLen:" + contentLen + ",");
		System.out.println("getPort:" + url.getPort());
		System.out.println("conn.getPermission():" + conn.getPermission());
		System.out.println("conn.getPermission().getName():"+conn.getPermission().getName());;
	}

	/**
	 * 模拟URLConnection.stripOffParameters(String contentType)方法
	 * 
	 * @param contentType
	 * @return
	 */
	private static String stripOffParameters(String contentType) {
		if (contentType == null)
			return null;
		int index = contentType.indexOf(';');

		if (index > 0)
			return contentType.substring(0, index);
		else
			return contentType;
	}

	@Test
	public void testString() {
		System.out.println("stripOffParameters:" + stripOffParameters("text/html; charset=UTF-8,"));
	}

	public static void main(String[] args) throws IOException {
		System.out.println("stripOffParameters:" + stripOffParameters("text/html; charset=UTF-8,"));
		new MyUrl().xxx(null);
	}
}
