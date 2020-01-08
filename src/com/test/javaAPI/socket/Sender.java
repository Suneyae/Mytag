package com.test.javaAPI.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 原文：http://www.cnblogs.com/dann/archive/2012/10/28/2743884.html
 * 
 * @author Wei
 * @time 2016年9月28日 下午10:36:34
 */
public class Sender {
	public static void main(String[] args) throws Exception {
		DatagramSocket sender = new DatagramSocket();// 1、创建DatagramSocket(可以设置本地端口,或由系统分配)
		String msg = "你好!";
		byte[] buf = msg.getBytes();
		/**
		 * Constructs a datagram packet for sending packets of length length to
		 * the specified port number on the specified host. The length argument
		 * must be less than or equal to buf.length. Parameters:buf the packet
		 * data.length the packet length.address the destination address.port
		 * the destination port number.
		 */
		DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);// 2、创建用于发送的DatagramPacket(主要设置发送的数据、远程地址和端口等信息)
		System.out.println("sender:发送信息----" + msg);
		sender.send(packet);// 3、通过DatagramSocket发送DatagramPacket
		System.out.println("sender:已经发送了信息");
		sender.close();// 4、关闭DatagramSocket

	}
}
