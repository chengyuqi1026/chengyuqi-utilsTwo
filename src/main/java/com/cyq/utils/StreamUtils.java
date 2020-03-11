package com.cyq.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @ClassName: StreamUtils
 * @Description: 流处理工具类
 * @author: ChengYQ
 * @date: 2020年3月11日 下午2:48:21
 */
public class StreamUtils {

	/**
	 * 
	 * @Title: closeAll
	 * @Description: 批量关闭流，参数能传入无限个
	 *               例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限
	 * @param src
	 * @throws IOException void
	 */
	public static void closeAll(AutoCloseable src) throws IOException {
		try {
			src.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	* @Title: readTextFile 
	* @Description: 传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，
	* 				要求方法内部调用上面第1个方法关闭流 
	* @param src
	* @return String
	 */
	@SuppressWarnings({ "finally", "unused" })
	public static String readTextFile(InputStream src) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(src, StandardCharsets.UTF_8));
		byte b[] = new byte[2048];
		int len = 0;
		int temp = 0;
		String stu = "";
		try {
			while ((temp = reader.read()) != -1) {
				b[len] = (byte) temp;
				len++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//调用第一个方法关闭流
				closeAll(src);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new String(b, 0, len);
		}
	}
	
	/**
	 * 
	* @Title: readTextFile 
	* @Description: 传入文本文件对象，返回该文件内容
	* @param txtFile
	* @return String
	 */
	@SuppressWarnings("finally")
	public static String readTextFile(File txtFile) {
		String file = "";
		try {
		FileInputStream inputStream = new FileInputStream(txtFile);
		file = readTextFile(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			return file;
		}
	}

}
