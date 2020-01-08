package com.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UtilHttp {

	public UtilHttp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 根据传入的url地址，发出get请求，并且获取请求的响应内容
	 * 
	 * @param webUrl
	 *            http请求地址
	 * @return
	 * @throws IOException
	 */
	public String httpGet(String webUrl) throws IOException {
		URL url = new URL(webUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		InputStream ips = conn.getInputStream();
		BufferedReader bfreader = new BufferedReader(new InputStreamReader(ips));
		StringBuilder builder = new StringBuilder();
		String str_tmp;
		while ((str_tmp = bfreader.readLine()) != null) {
			builder.append(str_tmp);
		}
		bfreader.close();
		conn.disconnect();
		return new String(builder.toString().getBytes(), "utf-8");
	}

	public static void main(String[] args) throws IOException {
		UtilHttp util = new UtilHttp();
		String url = "http://weibo.com/daxixis?refer_flag=1005055010_";
		// url = "http://weibo.com/1662585950/profile?topnav=1&wvr=6";
		url = "http://www.163.com/";
		url = "http://www.qq.com/";
		url = "https://www.baidu.com/";
		url = "http://www.xinhuanet.com/";
		String content = util.httpGet(url);
		System.out.println(content);
	}

	public void sendHttpPost(String webUrl, String param) throws IOException {

		URL url = new URL(webUrl);
		URLConnection conn = url.openConnection();
		// 设置通用属性
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
	}
	/**
	 * 发送post请求，还没写好
	 */
	public void sendHttpPost2(String webUrl, String param) throws IOException {

		URL url = new URL(webUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		//设置一些属性
		conn.setRequestMethod("POST");
		conn.setUseCaches(false);
		
		// 设置通用属性
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

	}
}
