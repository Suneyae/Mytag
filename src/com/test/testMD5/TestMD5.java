package com.test.testMD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.management.RuntimeErrorException;

public class TestMD5 {
	@SuppressWarnings("unused")
	public String MD5(String OperID, String PW) throws NoSuchAlgorithmException {
		String Encrypt = "";
		String tem = "";
		tem = OperID + PW.trim();

		if ((PW == null) || (PW.length() == 0)) {
			throw new RuntimeErrorException(null, "密码不能为空");
		}
		try {
			byte[] defaultBytes = tem.getBytes();

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(defaultBytes);
			byte[] messageDigest = md.digest();

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}

			Encrypt = hexString.toString();
		} catch (Error e) {
			// throw new AppException("密码加密出现异常(SecurityInfo.MD5)", e,
			// new Object[] { "OperID=" + OperID });
			throw new RuntimeErrorException(e);

		}

		return Encrypt;
	}

	// public deCode(String key, String message, boolean encrypt){
	// SecurityDes de = new SecurityDes();
	// Password = de.des(mykey, de.HexTostring(Password), false);
	// }

	public static void main(String[] args) throws NoSuchAlgorithmException {
		TestMD5 t = new TestMD5();
		String rtn = t.MD5("10006116", "aaaaaa");
		System.out.println("rtn:" + rtn + "Integer.toHexString:"
				+ Integer.toHexString(0xFF & new Byte("12")));
		
	}
}
