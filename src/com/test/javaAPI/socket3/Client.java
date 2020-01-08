package com.test.javaAPI.socket3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Client {
	public static void main(String[] args) throws IOException {
		//创建socket
		DatagramSocket c = new DatagramSocket();
//		new byte[];
		String msg = "我是要被传送的内容";
		byte[] buf = msg.getBytes();
		//把要发送的消息转为数据包
		SocketAddress a = null;
		DatagramPacket p = new DatagramPacket(buf, buf.length,new InetSocketAddress("127.0.0.1", 8899));
		c.send(p);
		c.close();
	}
}
