/**
 * 
 */
package com.compass.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.compass.users.model.MenuBean;
import com.compass.users.model.UserBean;
import com.compass.utils.AbstractService;

/**
 * @author wangyuchao
 * 
 */
public class UsersService extends AbstractService {
	/**
	 * 验证用户登录
	 * @param loginname
	 * @param password
	 * @param agencyId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserBean> checkLogin(String loginname, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginname", loginname);
		map.put("password", password);
		return dao.queryForList("login.checkLogin", map);
	}
	
	/**
	 * 获取主菜单
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MenuBean> getMenunew(String userid,String menuTreeBase){
		Map<String,String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("menuTreeBase", menuTreeBase);
		return dao.queryForList("MENU.getmenusnew", map);
	}
	
	/**
	 * 获取用户原始密码
	 * @param userId
	 * @return
	 */
	public String getUserLoginPwd(String userId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		return (String) dao.queryForObject("MENU.getUserLoginPwd", map);
	}
	
	/**
	 * 修改用户密码
	 * @param pwd
	 * @param userId
	 * @return
	 */
	public int updateUserLoginPwd(String pwd,String userId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pwd", pwd);
		map.put("userId", userId);
		return dao.update("MENU.updateUserLoginPwd", map);
	}
}
