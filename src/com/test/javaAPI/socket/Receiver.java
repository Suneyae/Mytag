package com.test.javaAPI.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 相当于服务器，用于接收数据
 * 
 * @author Wei
 * @time 2016年9月28日 下午10:43:40
 */
public class Receiver {
	public static void main(String[] args) throws Exception {
		DatagramSocket receiver = new DatagramSocket(10000);// 1、创建DatagramSocket(主要设置本地地址和端口等信息)
		byte[] buf = new byte[1024];
		/**
		 * 
		 * 
		 * Constructs a DatagramPacket for receiving packets of length length.
		 * 
		 * The length argument must be less than or equal to buf.length.
		 * 
		 * Parameters: buf buffer for holding the incoming datagram. length the
		 * number of bytes to read.
		 */
		DatagramPacket packet = new DatagramPacket(buf, buf.length);// 2、创建用于接受的DatagramPacket(不需要设置地址和端口)
		System.out.println("receiver:等待接收");

		/**
		 * void java.net.DatagramSocket.receive(DatagramPacket p) throws
		 * IOException
		 * 
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
		receiver.receive(packet);// 3、通过DatagramSocket接受发送方信息,填充DatagramPacket
		String msg = new String(packet.getData(), 0, packet.getLength());// 4、读取DatagramPacket的数据
		System.out.println("receiver:得到的信息是：-----" + msg);
		receiver.close();// 5、关闭DatagramSocket
	}
}
