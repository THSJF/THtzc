package runner;

import com.meng.TaiHunDanmaku.helpers.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Cry {
	private static byte[] Keys = new byte[] { 
		(byte) 79,(byte) 14,(byte) 42,(byte) 91,(byte) 9,(byte) 12,(byte) 143,(byte) 221,(byte) 62,(byte) 193,(byte) 178,(byte) 163,Byte.MAX_VALUE,(byte) 162,(byte) 5,(byte) 7
		};

	public static byte[] Decry(String FileName) throws Exception {
		byte[] numArray=Tools.readByteArray(new File(FileName));
		SecretKey secretKey = new SecretKeySpec(Tools.MD5(Keys), "DESede");//恢复密钥   
		Cipher cipher = Cipher.getInstance("DESede");//Cipher完成加密或解密工作类   
		cipher.init(Cipher.DECRYPT_MODE, secretKey);//对Cipher初始化，解密模式   
		byte[] cipherByte = cipher.doFinal(numArray);//解密data
		return cipherByte;
	}

	public static void printArr(byte[] arr) {
		for (byte b:arr) {
			System.out.printf(Integer.toHexString(b));
			System.out.printf(" ");
		}
		System.out.println();
    }
}
