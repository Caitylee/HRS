package com.qfedu.util;

import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * ���ù�����
 * @author ��
 *
 */
public final class CommonUtil {

	private CommonUtil() {
		throw new AssertionError();
	}
	
	/**
	 * ѹ��ͼƬ(��ͼƬ����ָ���ĳߴ�дΪPNG��ʽ��ͼƬ)
	 * @param inputStream ͼƬ����������������
	 * @param file Ŀ���ļ�
	 * @param width ѹ����Ŀ��
	 * @param height ѹ����ĸ߶�
	 * @throws IOException ��д�ļ�ʱ��������IOException
	 */
	public static void compressImage(InputStream inputStream, File file, 
			int width, int height) throws IOException {
		BufferedImage oldImage = ImageIO.read(inputStream);
		BufferedImage newImage = new BufferedImage(width, height, 
				BufferedImage.TYPE_INT_RGB);
		newImage.getGraphics().drawImage(oldImage, 0, 0, width, height, null);
		ImageIO.write(newImage, "PNG", file);
	}
	
	/**
	 * ���ȫ��Ψһ���ļ���
	 */
	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * ��ȡ�ļ����еĺ�׺��
	 * @param filename �ļ���
	 * @return ��׺��
	 */
	public static String getFilenameSuffix(String filename) {
		// assert filename != null;
		int index = filename.lastIndexOf(".");
		return index > 0 && index < filename.length() - 1 ? 
			filename.substring(index) : "";
	}
	
	/**
	 * ��ʱ�����ڸ�ʽ�����ַ���
	 * @param pattern ��ʽ
	 * @param date ʱ�����ڶ���
	 * @return ��ʽ�����ʱ�������ַ���
	 */
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	/**
	 * ���ַ���������ʱ������
	 * @param pattern ��ʽ
	 * @param str ʱ�������ַ���
	 * @return ʱ�����ڶ���
	 */
	public static Date stringToDate(String pattern, String str) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
