/**
 * 
 */
package com.compass.users.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.compass.role.service.RoleService;
import com.compass.users.model.MenuBean;
import com.compass.users.model.UserBean;
import com.compass.users.service.UsersService;
import com.compass.utils.ConstantUtils;
import com.compass.utils.MD5;
import com.compass.utils.mvc.AjaxReturnInfo;


/**
 * @author wangyuchao
 * 
 */
@Controller
@RequestMapping("/users/users.do")
public class UsersController {
	@Autowired
	@Qualifier("usersService")
	private UsersService usersService;
	
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;

	/**
	 * 用户登录
	 * @param loginname
	 * @param password
	 * @param agencyId
	 * @param request
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping(params = "method=checkLogin")
	@ResponseBody
	public AjaxReturnInfo checkLogin(
			@RequestParam(value = "loginname") String loginname,
			@RequestParam(value = "password") String password,
			HttpServletRequest request) throws ParserConfigurationException,
			SAXException, IOException {
		AjaxReturnInfo ajaxinfo = null;
		String tokeny = "NWC"+loginname+password;
		
		//获得角色id
		    String userId = request.getSession().getAttribute(ConstantUtils.USERID)==null?"":request.getSession().getAttribute(ConstantUtils.USERID).toString();
			if("".equals(userId)){
						 ajaxinfo = AjaxReturnInfo.failed("请选择系统");
						List<UserBean> list = usersService.checkLogin(loginname, password);
						if (list.size() == 0) {
							ajaxinfo = AjaxReturnInfo.failed("请检验机构编号，用户名，密码是否正确");
						} else {
							SetSessionData(request,list);
							tokeny= MD5.MD5(tokeny);
							ajaxinfo = AjaxReturnInfo.success("登录成功");
						}
			}else{
				ajaxinfo = AjaxReturnInfo.failed("本地不能同时登录多个用户!");
			}
		return ajaxinfo;
	}


private void SetSessionData(HttpServletRequest request,
		List<UserBean> list) {
	HttpSession session = request.getSession();
	session.setAttribute(ConstantUtils.USERID, list.get(0).getUserid());
	session.setAttribute(ConstantUtils.USERNAME, list.get(0).getUsername());
}
	/**
	 * 修改用户密码
	 * @param newPwd
	 * @param oldPwd
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=updateUserPwd")
	@ResponseBody
	public AjaxReturnInfo updateUserPwd(
			@RequestParam(value = "newPwd") String newPwd,
			@RequestParam(value = "oldPwd") String oldPwd,
			HttpServletRequest request){
		AjaxReturnInfo ajaxinfo = null;
		String userId = request.getSession().getAttribute(ConstantUtils.USERID).toString();
		String pwdStr = usersService.getUserLoginPwd(userId);
		if(oldPwd.trim().equals(pwdStr.trim())){
			int index = usersService.updateUserLoginPwd(newPwd,userId);
			if(index==0){
				ajaxinfo = AjaxReturnInfo.failed("修改失败");
			}else{
				ajaxinfo =  AjaxReturnInfo.success("修改成功");;
			}
		}else{
			ajaxinfo = AjaxReturnInfo.failed("原始密码不正确！");
		}
		return ajaxinfo;
		
	}
	
	/**
	 * 用户退出，销毁session
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(params = "method=destroySession")
	@ResponseBody
	public Map<String,Object> destroySession(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("des", "销毁");
		session.invalidate();	
				
	
		
		return map;
	}
	/**
	 * 获取用户所对应的菜单权限
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=getMenuTree")
	@ResponseBody
	public List<Map<String,Object>> getMenuTree(HttpServletRequest request){
		String userid=request.getSession().getAttribute(ConstantUtils.USERID).toString();
		List<MenuBean> menulist = usersService.getMenunew(userid,ConstantUtils.MENUTREEBASE);
		List<String> urlList = new ArrayList<String>();
		for(MenuBean bean:menulist){
			urlList.add(bean.getMenuUrl());
		}
		return createMenuTree(menulist, ConstantUtils.MENUTREEBASE);
	}
	/**
	 * 生成用户所对应的菜单树
	 * @param list
	 * @param id
	 * @return
	 */
	@RequestMapping(params = "method=getMenusetTree")
	@ResponseBody
	public List<Map<String, Object>> createMenuTree(List<MenuBean> list,
			String id) {
		List<Map<String, Object>> aulist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = null;
			MenuBean at = list.get(i);
			if (id.equals(at.getMenuFather())) {
				map = new HashMap<String, Object>();
				map.put("id", at.getMenuId());
				map.put("text", at.getMenuName());
				if ("0".equals(at.getChildCode())) {
					map.put("state", "open");
				} else {
					map.put("state", "open");
					map.put("children", createMenuTree(list, at.getMenuId()));
					List<Map<String,Object>> strlist=new ArrayList<Map<String,Object>>();
					Map<String,Object> z=new HashMap<String,Object>();
					z.put("url", at.getMenuUrl());
					strlist.add(z);
					map.put("attributes", z);
				}
				
			}
			if (map != null)
				aulist.add(map);
		}
		return aulist;
	}
}
