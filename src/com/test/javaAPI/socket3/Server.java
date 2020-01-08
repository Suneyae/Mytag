package com.test.javaAPI.socket3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		//
		DatagramSocket s = new DatagramSocket(8899);
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf, buf.length);
		s.receive(p);
		byte[] rtn = p.getData();
		int len = p.getLength();
//		System.out.println(new String(rtn,0,rtn.length));//我是要被传送的内容
		System.out.println(new String(rtn,0,len));
		s.close();
	}
}
