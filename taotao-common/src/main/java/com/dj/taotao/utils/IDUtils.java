package com.dj.taotao.utils;

import java.util.Random;

/**
 * @ClassName: IDUtils
 * @Description: 各种id生成策略
 * @author Steven
 * @date 2019年3月3日
 */
public class IDUtils {

	/**
	 * @Title: genImageName
	 * @Description: 图片名生成
	 * @return String 返回类型
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * @Title: genItemId
	 * @Description: 商品id生成
	 * @return long 返回类型
	 */
	public static long genItemId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			System.out.println(genItemId());
	}
}
