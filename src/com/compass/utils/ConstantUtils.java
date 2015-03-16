package com.compass.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author wangLong
 * 
 * 常量类
 *
 */

public class ConstantUtils {
   
	public static final String MENUTREEBASE = "0";
	
	public static final String USERID="userId";
	
	public static final String USERNAME="userName";
	
	public static final String COMBOXONEID= "-1" ;  //下拉框默认值
	
	public static final String COMBOXONETEXT= "===请选择===" ;  //下拉框默认文本
	
	public static final String DEFAULTROWS="20"; //表格默认显示记录数
	
	public static final String DEFAULTRPAGE ="1";//表格默认页
	
	
	
	
	/**
	 * 返回到页面中文乱码处理
	 * @param str
	 * @return
	 */
	public static  String getString(String str) {
		try {
			return new String(str.getBytes(), "ISO_8859_1" );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
}
