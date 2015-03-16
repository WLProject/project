package com.compass.utils;

import java.io.FileOutputStream;  
import java.io.IOException;  
import org.jdom.Document;  
import org.jdom.Element;  
import org.jdom.JDOMException;  
import org.jdom.output.XMLOutputter;  
  
public class XMLOutput {  
  
    public void BuildXMLDoc() throws IOException, JDOMException {  
  
        // 创建根节点 list;      
  
        Element root = new Element("Document");  
        // 根节点添加到文档中；      
        Document Doc = new Document(root);  
        // 此处 for 循环可替换成 遍历 数据库表的结果集操作;      
        for (int i = 0; i < 2; i++) {  
            // 赋值；      
        	root.addContent("\n");
        	root.addContent("\t");
            root.addContent(new Element("Freq").setText("男"));  
            root.addContent("\n");
            root.addContent("\t");
            root.addContent(new Element("SubNo").setText("某某"));  
            root.addContent("\n");
            root.addContent("\t");
            root.addContent(new Element("SubCode").setText("23"));  
            root.addContent("\n");
            root.addContent("\t");
            root.addContent(new Element("MT").setText("1"));  
            root.addContent("\n");
            root.addContent("\t");
            root.addContent(new Element("AT").setText("23"));  
            root.addContent("\n");
            root.addContent("\t");
            root.addContent(new Element("AC").setText("23"));  
            root.addContent("\n");
            root.addContent("\t");
            root.addContent(new Element("NbOfTxs").setText("23"));  
            root.addContent("\n");
        }  
  
        XMLOutputter XMLOut = new XMLOutputter();  
        // 输出 XMLOutput.xml 文件到项目根目录；     
        XMLOut.output(Doc, new FileOutputStream("XMLOutput.xml"));  
  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        try {  
  
            XMLOutput j2x = new XMLOutput();  
  
            System.out.println("生成 mxl 文件成功，请查看项目根目录XMLOutput.xml文件！");  
  
            j2x.BuildXMLDoc();  
  
        } catch (Exception e) {  
  
            e.printStackTrace();  
  
        }  
    }  
  
}  