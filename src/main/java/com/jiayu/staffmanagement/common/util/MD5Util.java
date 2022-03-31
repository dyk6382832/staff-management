package com.jiayu.staffmanagement.common.util;

import java.security.MessageDigest;

/**
 * 
 * @version: 1.00.00
 * @description: MD5加密工具类
 * @copyright: Copyright (c) 2021立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021年07月08日 下午4:29:27
 * @history:
 */
public class MD5Util {

	//加密秘钥
	private final static String KEY = "<md5@leelen.com>";
	
	/**
	 * 普通md5加密
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public final static String md5(String s) throws Exception {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		byte[] btInput = s.getBytes();
		// 获得MD5摘要算法的 MessageDigest 对象
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		// 使用指定的字节更新摘要
		mdInst.update(btInput);
		// 获得密文
		byte[] md = mdInst.digest();
		// 把密文转换成十六进制的字符串形式
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
	
	/**
	 * 通过秘钥进行MD5加密
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public final static String md5ByKey(String s) throws Exception {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		s = s + KEY;
		byte[] btInput = s.getBytes();
		// 获得MD5摘要算法的 MessageDigest 对象
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		// 使用指定的字节更新摘要
		mdInst.update(btInput);
		// 获得密文
		byte[] md = mdInst.digest();
		// 把密文转换成十六进制的字符串形式
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
}
