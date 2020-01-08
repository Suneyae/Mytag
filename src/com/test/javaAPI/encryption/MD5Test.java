package com.test.javaAPI.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// 1 生成消息摘要对象
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// 2 更新摘要
		md5.update("卫永乐".getBytes());
		// 3 完成哈希计算，得到结果
		byte[] rtn = md5.digest();
		System.out.println(rtn);
		System.out.println("rtn:"+new String(rtn));
		System.out.println(encrypt("卫永乐"));
	}
	/**
	 * 转自：http://www.iteye.com/topic/1122076/
	 * @param info
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] encrypt(String info) throws NoSuchAlgorithmException {
		// 根据MD5算法生成MessageDigest对象
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] srcBytes = info.getBytes();
		// 使用srcBytes更新摘要
		md5.update(srcBytes);
		// 完成哈希计算，得到result
		byte[] resultBytes = md5.digest();
		return resultBytes;
	}
	
	
//	public static void main(String args[]) throws NoSuchAlgorithmException{  
//        String msg = "郭XX-精品相声技术";  
//        MD5Test md5 = new MD5Test();  
//        byte[] resultBytes = md5.encrypt(msg);  
//        System.out.println("加密后的字节:"+resultBytes);
//        System.out.println("密文是：" + new String(resultBytes));  
//        System.out.println("明文是：" + msg);  
//    }  
}
