package com.test.javaAPI.socket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyServer {
	public static void main(String[] args) throws IOException {
		//准备套接字
		DatagramSocket socket = new DatagramSocket(8888);
		byte[] buf = new byte[1024];
		System.out.println("MyServer准备接收数据");
		// 封装套接字接收数据
		DatagramPacket p = new DatagramPacket(buf, buf.length);
		socket.receive(p);
		byte[] rtn = p.getData();
		System.out.println("接收到的消息:" + rtn.toString());
		System.out.println("接收到的消息:" + new String(p.getData(), 0, p.getLength()));
		socket.close();
	}
}
