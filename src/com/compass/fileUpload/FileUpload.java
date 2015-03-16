package com.compass.fileUpload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compass.utils.upload.FileUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("/upload/upload.do")
public class FileUpload {

	@RequestMapping(params = "method=upload")
	@ResponseBody
	public void upload(HttpServletRequest  request,HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		String logoPathDir = "/upload";     
		 String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir); 
		String str ="";
		PrintWriter print = null;
		try {
			print = response.getWriter();
			FileUtils.uploadFile(request, logoRealPathDir);
			 str = "上传成功";
			
		} catch (IOException e) {
			e.printStackTrace();
			 str = "上传失败";
		}
		Gson gosn = new Gson();
		print.write(gosn.toJson(str));
	}

}
