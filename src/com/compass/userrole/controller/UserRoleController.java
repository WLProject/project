package com.compass.userrole.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compass.role.service.RoleService;
import com.compass.userrole.model.UserRoleBean;
import com.compass.userrole.service.UserRoleService;
import com.compass.users.service.UsersService;
import com.compass.utils.CommonDate;
import com.compass.utils.ConstantUtils;
import com.compass.utils.mvc.AjaxReturnInfo;
/**
 * 
 * @author wangyuchao
 *
 */
@Controller
@RequestMapping("/userrole/userrole.do")
public class UserRoleController {
	
	@Autowired
	@Qualifier("userRoleService")
    private UserRoleService userRoleService;
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	@Autowired
	@Qualifier("usersService")
	private UsersService usersService;
	/**
	 * 用户查询	
	 * @param userName
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping(params ="method=inquire")
	@ResponseBody
	public Map<String,Object> getUsers(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "status") String status,
			HttpServletRequest request){
		UserRoleBean user=new UserRoleBean();
		user.setUserName(userName);
		user.setStatus(status);
		List<UserRoleBean> list = userRoleService.getUserRole(user);
		
		String page =request.getParameter("page");
		String rows = request.getParameter("rows");
		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		// 每页显示条数
		int number = Integer.parseInt((rows == null || rows == "0") ? "50"
				: rows);
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;
		int end = (start + number) > list.size() ? list.size() : start + number;
		List<UserRoleBean> beanList = new ArrayList<UserRoleBean>();
		if (list != null && list.size() > 0) {
			for (int i = start; i < end; i++) {
				beanList.add(list.get(i));
			}
		}
		return AjaxReturnInfo.setTable(list==null?0:list.size(), beanList);

	}
	/**
	 * 用户添加
	 * @param userName
	 * @param loginName
	 * @param password
	 * @param email
	 * @param phone
	 * @param status
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping(params ="method=add")
	@ResponseBody
	public AjaxReturnInfo useradd(@RequestParam(value = "userName") String userName,
									@RequestParam(value = "loginName") String loginName,
									@RequestParam(value = "password") String password,
									@RequestParam(value = "email") String email,
									@RequestParam(value = "phone") String phone,
									@RequestParam(value = "status") String status,
									HttpServletRequest request){
			String createId=request.getSession().getAttribute(ConstantUtils.USERID)+"";
			String createDt=CommonDate.getDate();
			UserRoleBean userRoleBean = new UserRoleBean();
			String userId=userRoleService.getUserId().toString();
			userRoleBean.setUserId(userId);
			userRoleBean.setUserName(userName);
			userRoleBean.setLoginName(loginName);
			userRoleBean.setPassword(password);
			userRoleBean.setEmail(email);
			userRoleBean.setPhone(phone);
			userRoleBean.setStatus(status);
			userRoleBean.setCreateId(createId);
			userRoleBean.setCreateDt(createDt);
			List<Map<String,Object>> maplist=roleService.getRoleId("");
			AjaxReturnInfo ajaxReturnInfo = AjaxReturnInfo.success("保存成功!");	
			int checkuser=userRoleService.checkUser(loginName);
			if(checkuser==0){
				String roleId=maplist.get(0).get("ROLEID").toString();
				userRoleService.addUserRole(userId,roleId,createId,createDt);
				int resule = userRoleService.getInsert(userRoleBean);
				if(resule==0){
					ajaxReturnInfo = AjaxReturnInfo.failed("保存失败!");
				
				}
			}else{
				ajaxReturnInfo = AjaxReturnInfo.failed("登录名已经被占用!");
			}
			
			return ajaxReturnInfo;
	}
	/**
	 * 修改用户
	 * @param userId
	 * @param userName
	 * @param loginName
	 * @param password
	 * @param email
	 * @param phone
	 * @param status
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping(params ="method=update")
	@ResponseBody
	public AjaxReturnInfo userupdate(
									@RequestParam(value = "userId") String userId,
									@RequestParam(value = "userName") String userName,
									@RequestParam(value = "loginName") String loginName,
									@RequestParam(value = "password") String password,
									@RequestParam(value = "email") String email,
									@RequestParam(value = "phone") String phone,
									@RequestParam(value = "status") String status,
									HttpServletRequest request){
					UserRoleBean userRoleBean = new UserRoleBean();
					String modifyId=request.getSession().getAttribute(ConstantUtils.USERID)+"";
					String modifyDt=CommonDate.getDate();
					userRoleBean.setUserId(userId);
					userRoleBean.setUserName(userName);
					userRoleBean.setLoginName(loginName);
					userRoleBean.setPassword(password);
					userRoleBean.setEmail(email);
					userRoleBean.setPhone(phone);
					userRoleBean.setModifyId(modifyId);
					userRoleBean.setModifyDt(modifyDt);
					userRoleBean.setStatus(status);
					int checkuser=userRoleService.checkUser(loginName);
					AjaxReturnInfo ajaxReturnInfo=null;
					if(checkuser==0){
			            int resule = userRoleService.getUpdate(userRoleBean);
						ajaxReturnInfo = AjaxReturnInfo.success("保存成功!");			
						if(resule==0){
						ajaxReturnInfo = AjaxReturnInfo.failed("保存失败!");
						}
					}else{
						ajaxReturnInfo = AjaxReturnInfo.failed("登录名已经被占用!");
					}
					
			
			
			return ajaxReturnInfo;
	}

	/**
	 * 删除用户，支持批量删除
	 * @param userIds
	 * @return
	 */
	@RequestMapping(params ="method=delete")
	@ResponseBody
	public AjaxReturnInfo userdelete(@RequestParam(value = "userIds") String userIds){
		
		AjaxReturnInfo ajaxReturnInfo = AjaxReturnInfo.failed("删除失败");		
		int resule = 0; 
		userIds=userIds.substring(0, userIds.length()-1);
		String []tt=userIds.split(",");
		for(int i=0;i<tt.length;i++){
			UserRoleBean userRoleBean = new UserRoleBean();
			userRoleBean.setUserId(tt[i]);		
			//int status = 0;
			userRoleBean.setStatus("0");
			resule+= userRoleService.getDelete(userRoleBean);
		}
		
		if(resule==tt.length){
			ajaxReturnInfo = AjaxReturnInfo.success("删除成功!");
		}
	
		return ajaxReturnInfo;
	
		
	}
	/**
	 * 查看用户所拥有的权限
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping(params ="method=getRoleC")
	@ResponseBody
	public List<Map<String,Object>> getRoleC(@RequestParam(value = "userId") String userId,
			HttpServletRequest request){
		List<UserRoleBean> list=userRoleService.getRoleC(userId);
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		for(UserRoleBean obj:list){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("userId", obj.getUserId());
			map.put("roleId", obj.getRoleId());
			listmap.add(map);
		}
		return listmap;
	}
	/**
	 * 重置用户密码(超级管理员和管理员拥有该权限)
	 * @param userId
	 * @param userPwd
	 * @param request
	 * @return
	 */
	@RequestMapping(params ="method=resetPwd")
	@ResponseBody
	public AjaxReturnInfo resetPwd(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "userPwd") String userPwd,
			HttpServletRequest request){
		AjaxReturnInfo ajaxReturnInfo = null;
		int result = usersService.updateUserLoginPwd(userPwd, userId);
		if(result==0){
			ajaxReturnInfo = AjaxReturnInfo.failed("密码重置失败！");
		}else{
			ajaxReturnInfo = AjaxReturnInfo.success("密码已重置！");
		}
		return ajaxReturnInfo;
		
	}
}
