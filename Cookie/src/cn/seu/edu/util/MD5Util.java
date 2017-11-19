package cn.seu.edu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static final String getMD5String(String strIn) {
		try {
			// 获得MD5加密实例
			MessageDigest md5Instance = MessageDigest.getInstance("MD5");
			// 计算摘要
			md5Instance.update(strIn.getBytes());
			// 获得hash值
			byte[] digest = md5Instance.digest();
			// 机制转换
			String md5String = new BigInteger(1, digest).toString().toUpperCase();
			return md5String;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}
