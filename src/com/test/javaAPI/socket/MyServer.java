package com.test.javaAPI.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyServer {
	public static void main(String[] args) throws IOException {

		// 1 创建服务端+端口
		DatagramSocket server = new DatagramSocket(8899);
		// 2 准备接收容器
		byte[] container = new byte[1024];

		// 3 封装成DatagramPacket
		DatagramPacket packet = new DatagramPacket(container, container.length);

		/**
		 * Receives a datagram packet from this socket. When this method
		 * returns, the DatagramPacket's buffer is filled with the data
		 * received. The datagram packet also contains the sender's IP address,
		 * and the port number on the sender's machine.
		 * 
		 * This method blocks until a datagram is received. The length field of
		 * the datagram packet object contains the length of the received
		 * message. If the message is longer than the packet's length, the
		 * message is truncated.
		 * 
		 * If there is a security manager, a packet cannot be received if the
		 * security manager's checkAccept method does not allow it.
		 * 
		 */
		// 4 接收数据
		server.receive(packet);

		// 5 分析数据
		byte[] data = packet.getData();

		int len = packet.getLength();
		System.out.println(new String(data, 0, len));
		// 6 释放资源
		server.close();
	}
}
