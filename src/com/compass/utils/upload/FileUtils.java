/**
 * 
 */
package com.compass.utils.upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**	
 * @project GDR GAOTIME-DATABASE-RELESEASE
 * @title   cn.com.inxite.web.common.fileupload.FileUtils.java
 * @desc    
 * @version 0.5.0
 * @create date 2010-9-9
 * 
 * @modify list:
 */
public class FileUtils {
	
	/**
	 * 上传至指定目录下
	 * @param request
	 * @param path
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void uploadFile(HttpServletRequest request,String path) throws IOException{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> it= multipartRequest.getFileNames();
		CommonsMultipartFile file = null;
		while(it.hasNext())
		{
			String name = (String)it.next();
			file = (CommonsMultipartFile)multipartRequest.getFile(name);
			System.out.println("contenttype: "+file.getContentType());
			System.out.println("name: "+file.getName());
			System.out.println("origiginalFilename: "+file.getOriginalFilename());
			System.out.println("size: "+file.getSize());
			String filename = file.getOriginalFilename();//文件名
			if(filename!=null&&!"".equals(filename))
			{
				File dirPath = new File(path);
				if (!dirPath.exists()) {
					dirPath.mkdirs();
				}
				String sep = System.getProperty("file.separator");
				File uploadedFile = new File(path + sep+ file.getOriginalFilename());
				FileCopyUtils.copy(file.getBytes(), uploadedFile);
			}
	   }
	}
}
