package com.test.javaAPI.socket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class MyClient {
	public static void main(String[] args) throws IOException {
		//准备套接字
		DatagramSocket client = new DatagramSocket();
		// 准备发送内容
		String msg = "我是将要被发送的信息...";
		byte[] buf = msg.getBytes();
		// 封装发送内容为数据包
		DatagramPacket p = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 8888));
		// 发送数据包
		client.send(p);
		System.out.println("client发送数据");
		// 关闭数据包
		client.close();
	}
}
