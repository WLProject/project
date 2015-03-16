package com.compass.utils.mail;

import com.compass.utils.CommonParam;

public class SendMail {

	public static void sendMain(String toAddress,String title,String content){
		//这个类主要是设置邮件   
	      MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost(CommonParam.getString("mailHost"));    
	      mailInfo.setMailServerPort(CommonParam.getString("mailPort"));    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName(CommonParam.getString("mailName"));    
	      mailInfo.setPassword(CommonParam.getString("mailPort"));//您的邮箱密码    
	      mailInfo.setFromAddress(CommonParam.getString("mailPass"));    
	      mailInfo.setToAddress(toAddress);    
	      mailInfo.setSubject(title);    
	      mailInfo.setContent(content);
	      SimpleMailSender sms = new SimpleMailSender();
	    //sms.sendTextMail(mailInfo);//发送文体格式    
	      sms.sendHtmlMail(mailInfo);//发送html格式   
	}
}
