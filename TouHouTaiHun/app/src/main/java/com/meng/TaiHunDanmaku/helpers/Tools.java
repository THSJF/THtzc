package com.meng.TaiHunDanmaku.helpers;

import java.io.*;
import java.nio.charset.*;
import java.security.*;

public class Tools {

	public static String readString(String fileName) {
		return readString(new File(fileName));
	}

	public static String readString(File f) {
		String s = "";
		try {      
			long filelength = f.length();
			byte[] filecontent = new byte[(int) filelength];
			FileInputStream in = new FileInputStream(f);
			in.read(filecontent);
			in.close();
			s = new String(filecontent, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static byte[] readByteArray(File f) {
		byte[] filecontent=null;
		try {
			long filelength = f.length();
			filecontent = new byte[(int) filelength];
			FileInputStream in = new FileInputStream(f);
			in.read(filecontent);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filecontent;
	}

	public static byte[] MD5(byte[] bs) {
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(bs);
			return mdTemp.digest();
		} catch (Exception e) {
			return null;
		}
	}

	public static String MD5StrSplited(byte[] bs) {
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(bs);
			return toHexString(mdTemp.digest());
		} catch (Exception e) {
			return null;
		}
	}

	private static String toHexString(byte[] md) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int j = md.length;
		char str[] = new char[j * 5];
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[i * 5] = '0';
			str[i * 5 + 1] = 'x';
			str[i * 5 + 2] = hexDigits[byte0 >>> 4 & 0xf];
			str[i * 5 + 3] = hexDigits[byte0 & 0xf];
			str[i * 5 + 4] = ' ';
		}
		return new String(str, 0, str.length - 1);
	}
}

