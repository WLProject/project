<%@page import="com.compass.utils.ConstantUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<style type="text/css">
		#fm {
			margin: 0;
			padding: 10px 30px;
		}
		.ftitle {
			font-size: 14px;
			font-weight: bold;
			padding: 5px 0;
			margin-bottom: 10px;
			border-bottom: 1px solid #ccc;
		}
		
		.fitem {
			margin-bottom: 5px;
		}
		
		.fitem label {
			display: inline-block;
			width: 80px;
}
</style>
<script type="text/javascript">
$(window).resize(function(){
	 $('#userList').datagrid('resize', {
	 	width:cs()
	 });
}); 
function cs(){	
	return $(window).width()-6;
}
	var url;
	var agencyId;
	function addUsers() {
		agencyId='';
		$('#userId').val('');
		$('#userName').val('');
		$('#loginName').val('');
		$('#password').val('');
		$('#email').val('');
		$('#phone').val('');
		$('#address').val('');
		$("#status").combobox('select', 1);
		$.showDivShade('${ctx}');
		$('#dlg').dialog('open').dialog('setTitle', '新增用户信息');	
		$("#status").combobox('select', 1);
		url = '${ctx}/userrole/userrole.do?method=add';
	}

	//修改
	function editUser(obj) {
			
		$.showDivShade('${ctx}');
		var rows = $('#userList').datagrid('getSelections');
		var len = rows.length;
		var row = $('#userList').datagrid('getSelected');
		if (len > 1) {
			$.hideDivShade();
			$.messager.alert("提示 ", "只能对单条记录修改");
			return;
		}else if(len==0){
			$.hideDivShade();
			$.messager.alert("提示 ", "请选择要修改的记录");
			return;
		}
		$('#userId').val(row.userId);
		$('#userName').val(row.userName);
		$('#loginName').val(row.loginName);
		$('#password').val(row.password);
		$('#email').val(row.email);
		$('#phone').val(row.phone);
		$('#address').val(row.address);
		agencyId=row.agencyId;
		$("#status").combobox('select', row.status);
		url = "${ctx}/userrole/userrole.do?method=update";
		$('#dlg').dialog('open').dialog('setTitle', '修改用户信息');
	}
	//添加
	function saveUser() {
		var userId = $('#userId').val();
		var userName = $('#userName').val();
		var loginName = $('#loginName').val();
		var password = $('#password').val();
		password=hex_md5(password);
		var email = $('#email').val();
		var phone = $('#phone').val();
		var status = $("#status").combobox("getValue");
		//var roleId=$('#roleId').combobox('getValue');

		if ($.trim(userName) == "") {
			$.messager.alert("提示 ", "请输入用户名称");
			return false;
		}
		if ($.trim(loginName) == "") {
			$.messager.alert("提示 ", "请输入登录名称");
			return false;
		}
		if ($.trim(password) == "") {
			$.messager.alert("提示 ", "请输入用户密码");
			return false;
		}
		if ($.trim(email) == "") {
			$.messager.alert("提示 ", "请输入用户邮箱");
			return false;
		}
		if ($.trim(phone) == "") {
			$.messager.alert("提示 ", "请输入用户电话");
			return false;
		}

		if ($.trim(status) == "") {
			$.messager.alert("提示 ", "请选择用户状态");
			return false;
		}
		if (!(/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/)
				.test($.trim(email))) {
			$.messager.alert("提示 ", "邮箱格式不正确");
			return false;
		}
		$('#save').linkbutton('disable');
		$.post(url, {
			userId : userId,
			userName : userName,
			loginName : loginName,
			password : password,
			email : email,
			phone : phone,
			status : status,
			agencyId:agencyId

		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	}
	$.success = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
		$.close();
		userView();
	
	};

	$.failed = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
	};
	$.close=function(){
		$('#dlg').dialog('close');
		$.hideDivShade();
	};
	//删除
	function destroyEmail() {
		var userid='<%=session.getAttribute(ConstantUtils.USERID)%>';
		var row = $('#userList').datagrid('getSelections');
		var userIds = "";

		if (row.length < 1) {
			$.messager.alert("提示 ", "请先选中要删除的数据");
		} else {
			$.messager.confirm('提示', '您确定要删除该数据？', function(r) {
				if (r) {
					for ( var i = 0; i < row.length; i++) {
						var status = row[i].status;
						userIds = userIds + "'" + row[i].userId + "',";
						if (status == '0') {
							$.messager.alert("提示 ", "对不起!该角色已无效,不能删除!");
							return;
						}
						if($.trim(row[i].userId)==$.trim(userid)){
							$.messager.alert("提示 ", "当前登录的用户不能删除");
							return;
						}
					}
					$.post('${ctx}/userrole/userrole.do?method=delete', {
						userIds : userIds
					}, function(data) {
						$.parseAjaxReturnInfo(data, $.success, $.failed);
					}, "json");
				}
			});
		}
	}

	function resetPwd(){
		$.showDivShade('${ctx}');
		var rows = $('#userList').datagrid('getSelections');
		var len = rows.length;
		var row = $('#userList').datagrid('getSelected');
		if (len > 1) {
			$.hideDivShade();
			$.messager.alert("提示 ", "只能对单条记录修改");
			return;
		}else if(len==0){
			$.hideDivShade();
			$.messager.alert("提示 ", "请选择要修改的记录");
			return;
		}
		var userId = row.userId;
		var userPwd = row.loginName;
		userPwd=hex_md5(userPwd);
		$.messager.confirm('提示', '您确定要重置？', function(r) {
			if(r){
				$.post('${ctx}/userrole/userrole.do?method=resetPwd', 
		            	{
							userId : userId,
							userPwd : userPwd
						}, 
						function(data) {
						$.parseAjaxReturnInfo(data, $.success, $.failed);
					}, "json");
			}
			$.hideDivShade();
		});
	}
	
	function userView() {
		var status = $("#statusStr").combobox('getValue');
		var userName = $("#userNameAndId").val();
		$('#userList').datagrid(
						{
							title : '用户管理',
							url : '${ctx}/userrole/userrole.do?method=inquire',
							queryParams : {								
								status : status,
								userName : userName
							},
							pageSize:20,
							width : $(window).width()-6,
							height : $(window).height() * 0.90,
							fitColumns:true,
							frozenColumns : [ [ {
								field : 'ck',
								checkbox : true,
								width : "50"
							} ] ],
							columns : [ [
									{field : "userId",width : $(window).width()*0.1,title : "用户ID",align : "center",hidden : true},
									{field : "userName",width : $(window).width()*0.1,title : "用户名称",align : "center"},
									{field : "loginName",width : $(window).width()*0.1,title : "登录名称",align : "center"},
									{field : "password",width : $(window).width()*0.1,title : "登录密码",align : "center",hidden : true},
									{field : "roleId",width : $(window).width()*0.3,title : "用户类型",align : "center"},
									{field : "email",width : $(window).width()*0.2,title : "邮箱",align : "center"},
									{field : "phone",width : $(window).width()*0.15,title : "电话",align : "center"},
									{field : "statusStr",width : $(window).width()*0.1,title : "状态",align : "center"},
									{field : "comments",width : $(window).width()*0.1,title : "备注 ",align : "center",hidden : true},
									{field : "createId",width : $(window).width()*0.1,title : "操作人 ",align : "center",hidden : false},
									{field : "createDt",width : $(window).width()*0.15,title : "操作时间 ",align : "center",hidden : false}
							] ],
							hideColumn : [ [ {
								field : "status",
								field : "agencyId"
							} ] ],
							pagination : true,
							rownumbers : true,
							showFooter : true,
							toolbar:[{
								id:'btnadd',
								text:'添加',
								iconCls:'icon-add',
								handler:function(){									
									addUsers();
								}
							},'-',{
								id:'btncut',
								text:'修改',
								iconCls:'icon-edit',
								handler:function(){
									editUser(-2);
									
								}
							},'-',{
								id:'btndelete',
								text:'删除',
								iconCls:'icon-cut',
								handler:function(){
									destroyEmail();
									
								}
							},'-',{
								id:'btnReset',
								text:'密码重置',
								iconCls:'icon-reload',
								handler:function(){
									resetPwd();
									
								}
							}]
						});
		var p = $('#userList').datagrid('getPager');
		$(p).pagination({
			pageList : [ 20 ],
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	}

	$(function() {
		userView();
		$("select").combobox({
			editable:false 
		});
	
	});
	
</script>
</head>
<body id="indexd">
	<table width="100%">
		<tr>
			<td width="60">用户名称：</td>
			<td width="160" align="left">
				<input type="text" name="userNameAndId" id="userNameAndId" style="width: 150px;" />
			</td>
			<td width="60" align="left">用户状态：</td>
			<td width="160" align="left">
				<select class="easyui-combobox" data-options="panelHeight:'auto'" 
				id="statusStr" name="statusStr" style="width: 150px;">
					<option value="1" selected="selected">有效</option>
					<option value="0">无效</option>
				</select>
			</td>
			<td>
				<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onclick="userView()">查询</a>
			</td>
		</tr>
	</table>
	<table id="userList"></table>
	
	
	<div id="dlg" class="easyui-window" title="用户更新" closed=true cache ="false" collapsible="false" zIndex="20px"  
       minimizable="false" maximizable="false" resizable="false" draggable="false"  closable="false"
       style="width:512px;height:230px;top:100px;padding:0px;background: #fafafa; overflow: hidden;">
	    <div class="easyui-layout" fit="true">	    
		<div region="center" border="true" style="padding:10px;background:#fff;overflow: hidden;">
	    		<table>
	    			<tr>	    				
	    				<td>用户名称：</td>
	    				<td>
		    				<input type="text" name="userName" id="userName" maxlength="100" /><input
						type="text" name="userId" id="userId" style="display: none;" />
	    				</td>	   
	    				<td > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录名称：</td>
	    				<td>
	    					<input type="text" name="loginName" id="loginName" maxlength="100"/>
	    				</td>	 			
	    			</tr>
	    			<tr>	    				
	    				<td>登录密码：</td>
	    				<td>
		    				<input type="password" name="password" id="password" maxlength="20" style="width: 155px"/>
	    				</td>	   
	    				<td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱地址：</td>
	    				<td>
	    					<input type="text" name="email" id="email" maxlength="50"/>   
	    				</td>	 			
	    			</tr>
	    			<tr>	    				
	    				<td>电话号码：</td>
	    				<td>	    				 
	    					<input type="text" name="phone" id="phone" maxlength="11" onkeyup="value=this.value.replace(/\D+/g,'')"/>
	    				</td>	   
	    				<td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标记状态：</td>
	    				<td>
		    					<select class="easyui-combobox" id="status"
							name="status" data-options="panelHeight:'auto'" style="width: 155px;">
								<option value="1" selected="selected">有效</option>
								<option value="0">无效</option>
						</select>   
	    				</td>	 			

	    			</tr>
	    			<tr style="height: 50px">
	    				<td align="center" colspan="4">
	    				    <a name="save" id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="saveUser()">保存</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    				   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    					<a name="close" id="close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$.close()">关闭</a> 

	    				</td>
	    			</tr>
	    		</table>
	     	</div>
	    	</div>
	    </div>
</body>
</html>