package com.test.javaAPI.wechat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/**
 * 加密引用自：http://www.henkuai.com/thread-11456-1-1.html
 * @author Wei
 * @time  2016年10月13日 上午9:26:08
 */

public class CheckUtil {
	private static final String token = "WeiyongleWechat";

	public static boolean checkSignature(String signature, String timestamp, String nonce) {

		String[] arr = new String[] { token, timestamp, nonce };

		// 排序
		Arrays.sort(arr);
		// 生成字符串
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		// sha1加密
		String temp = getSHA1String(content.toString());

		return temp.equals(signature); // 与微信传递过来的签名进行比较
	}

	private static String getSHA1String(String str) {
		// return DigestUtils.sha1Hex(data); // 使用commons codec生成sha1字符串
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1"); // 如果是SHA加密只需要将"SHA-1"改成"SHA"即可
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexStr = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexStr.append(0);
				}
				hexStr.append(shaHex);
			}
			return hexStr.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
