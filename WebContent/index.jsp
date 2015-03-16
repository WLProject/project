<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
input{ vertical-align:middle; margin:0; padding:0}
.file-box{ position:relative;width:340px}
.txt{ height:30px; border:1px solid #cdcdcd; width:180px;}
.btn{ background-color:#FFF; border:1px solid #CDCDCD;height:30px; width:70px;}
.file{ position:absolute; top:0; right:80px; height:30px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
<style>
.datagrid-cell-rownumber{
	width:50px;
	text-align:center;
	margin:0px;
	padding:3px 0px;
	color:#000;
}
.datagrid-header-rownumber{
	width:50px;
	text-align:center;
	margin:0px;
	padding:3px 0px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title> 存款</title>
<%@ include file="/commons/taglibs.jsp"%>
<script type="text/javascript">
//上传导入功能
$.upload = function() {
	
  	$("#uploadBtn").linkbutton('disable');
  	var name = $("#upload_file").val();
  	
    if(name ==""){
    	$.messager.alert("提示","请选择要上传的文件！");
    	$("#uploadBtn").linkbutton('enable');
      	return;
    }
$.ajaxFileUpload({
       url:"${ctx}/upload/upload.do?method=upload",
       secureuri:false,
       fileElementId:'upload_file',
       dataType: 'json',
       
       success:function(data,textStatus) {
     	 	var str = eval("(" +data+ ")");
     	 	$("#uploadBtn").linkbutton('enable');
     	 		alert(str);
       		}	
    	 }
		); 
};

</script>
</head>
<body>
 <table>
 		<tr>
			<td  nowrap="nowrap">
				<div class="file-box">
						 <input type='text' name='textfield' id='textfield' class='txt' />  
						 <input type='button' class='btn' value='浏览...' />
						 <input type="file" name="upload_file" class="file" id="upload_file" size="28" onchange="document.getElementById('textfield').value=this.value" />
						 <a href="#" class="easyui-linkbutton" id="uploadBtn" name="uploadBtn" class="btn" iconCls="icon-add" plain="true" onclick="$.upload()">上传</a>
				</div>
			</td>
		</tr>
 </table>
</body>
</html>