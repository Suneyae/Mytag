package com.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 参考:http://www.cnblogs.com/yanghuahui/p/3683600.html
 * 
 * @author Wei
 * @time 2016年10月27日 下午2:58:29
 */
public class FileChannelTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		String filePath = "C:/Users/Wei/Desktop/a.txt";

		// RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt",
		// "rw");
		File file = new File(filePath);
		RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
		FileChannel inChannel = aFile.getChannel();
		// 涉及到的buffer的方法稍后解释
		ByteBuffer buf = ByteBuffer.allocate(48);
		//把FileChannel 中的字节序列读取到 ByteBuffer中，并返回读取的字节数量
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			// make buffer ready for read
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());// read 1 byte at a time
			}
			buf.clear();// buf.compact();也可以
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
	
	public void testChannel(){
//		Channels.newChannel
	}
}
