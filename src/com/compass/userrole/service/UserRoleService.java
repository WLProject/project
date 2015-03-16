package com.compass.userrole.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.compass.userrole.model.UserRoleBean;
import com.compass.utils.AbstractService;
/**
 * 
 * @author wangLong
 *
 */
public class UserRoleService extends AbstractService{
	/**
	 * 生成用户编号
	 * @return
	 */
	public Integer getUserId(){
		return (Integer) dao.queryForObject("SEQUENCE.getUserId");
	}
	/**
	 * 用户查询
	 * @param user
	 * @return
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public List<UserRoleBean> getUserRole(UserRoleBean user){

		@SuppressWarnings("unchecked")
		List<UserRoleBean> list = dao.queryForList("USERROLE.inquire",user);
		return list;
	}
	/**
	 * 查询用户所拥有的权限
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserRoleBean> getRoleC(String userId){
		return dao.queryForList("USERROLE.getRolec", userId);
	}
	/**
	 * 添加用户
	 * @param userRoleBean
	 * @return
	 */
	public int getInsert(UserRoleBean userRoleBean){
		int useradd = dao.insert("USERROLE.add", userRoleBean);
		return useradd;
	}
	/**
	 *修改用户
	 * @param userRoleBean
	 * @return
	 */
	public int getUpdate(UserRoleBean userRoleBean){
		int userupdate = dao.update("USERROLE.update", userRoleBean);
		return userupdate;
	}
	/**
	 * 删除用户
	 * @param userRoleBean
	 * @return
	 */
	public int getDelete(UserRoleBean userRoleBean){
		int userdelete = dao.delete("USERROLE.delete", userRoleBean);
		return userdelete;
	}
	

	/**
	 * 为用户添加角色
	 * @param userId
	 * @param roleId
	 * @param createId
	 * @param createDt
	 * @return
	 */
	public int addUserRole(String userId, String roleId,String createId,String createDt) {
		// TODO Auto-generated method stub
		Map<String,String> map= new HashMap<String,String>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		map.put("createId", createId);
		map.put("createDt", createDt);
		
		return dao.insert("USERROLE.addUserRole",map);
	}
	/**
	 * 通过用户编号来删除用户的角色
	 * @param userId
	 * @return
	 */
	public int delRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.delete("USERROLE.delRoleByUserId", userId);
	}
	/**
	 * 获取用户所对应的数据
	 * @param userId
	 * @return
	 */
	public Integer getUserRelation(String userId){
		return (Integer)dao.queryForObject("role.getUserRelation", userId);
	}
	/**
	 * 验证登录名称是否存在
	 * @param loginname
	 * @param agencyId
	 * @return
	 */
	public Integer checkUser(String loginname){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loginname", loginname);
		return (Integer) dao.queryForObject("USERROLE.checkUser",map);
	}
	
}
