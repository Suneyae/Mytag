package com.test.javaAPI.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 188课 00:54秒
 * 
 * @author Wei
 * @time 2016年9月28日 下午10:30:03
 */
public class MyClient {

	public static void main(String[] args) throws IOException {
		// 1 创建服务端 端口
		DatagramSocket client = new DatagramSocket();

		// 2 准备数据
		String msg = "我是要被发送的数据,Dan。";
		byte[] data = msg.getBytes();

		// 3 打包
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("127.0.0.1", 8899));

		// 4 发送
		client.send(packet);

		// 5 释放

		client.send(packet);

	}
}
