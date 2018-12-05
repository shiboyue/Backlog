package com.cyh.sy.common;

import java.security.MessageDigest;

/**
 * MD5加密类
 * @描述：
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:55:57
 *
 */
public final class MD5 {

	/**
	 * Md5加密
	 * @param s
	 * @return
	 */
	public final static String md5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4',
                             '5', '6', '7', '8', '9',
                             'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(MD5.md5("123456"));
	}
}
