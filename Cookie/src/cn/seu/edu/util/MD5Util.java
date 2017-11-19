package cn.seu.edu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static final String getMD5String(String strIn) {
		try {
			// ���MD5����ʵ��
			MessageDigest md5Instance = MessageDigest.getInstance("MD5");
			// ����ժҪ
			md5Instance.update(strIn.getBytes());
			// ���hashֵ
			byte[] digest = md5Instance.digest();
			// ����ת��
			String md5String = new BigInteger(1, digest).toString().toUpperCase();
			return md5String;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}
