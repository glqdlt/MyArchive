package org.glqdlt.home.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {

	public static String extractStringHashSHA256(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

	public static String extractFileHashSHA256(String filename) throws Exception {

		File file = new File(filename);

		InputStream is = new FileInputStream(file);

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] t_byte_arr = new byte[1024];

		int t_byte_arr_length;

		while ((t_byte_arr_length = is.read(t_byte_arr)) != -1) {

			md.update(t_byte_arr, 0, t_byte_arr_length);

		}

		is.close();

		byte[] hash_arr = md.digest();

		String hashToString = "";

		for (int i = 0; i < hash_arr.length; i++) {

			hashToString += Integer.toString((hash_arr[i] & 0xff) + 0x100, 16).substring(1);

		}

		return hashToString;
	}

	public static String extractFileHashSHA256_2(String filename) throws Exception {

		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		InputStream is = null;
		try {
			is = new FileInputStream(filename);
			byte[] buffer = new byte[1024];
			int readBytes = 0;

			while ((readBytes = is.read(buffer)) > -1) {
				md.update(buffer, 0, readBytes);
			}

			StringBuilder builder = new StringBuilder();
			byte[] digest = md.digest();
			for (byte b : digest) {
				builder.append(Integer.toHexString(0xff & b));
			}
			return builder.toString();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
