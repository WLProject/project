package com.compass.rolemenu.service;

/**
 * @author wangLong
 */

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.compass.authority.model.AuthorityBean;
import com.compass.rolemenu.model.RoleMenuBean;
import com.compass.utils.AbstractService;

public class RoleMenuService extends AbstractService{
	/**
	 * 保存
	 * @param roleMenuBean
	 * @return
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public int saveAuths(RoleMenuBean roleMenuBean){
		return dao.insert("ROLE_AUTH.saveAuths", roleMenuBean);
	}
	
	/**
	 * 删除角色权限
	 * @param roleId
	 * @return
	 */
	public int delAuths(String roleId){
		return dao.delete("ROLE_AUTH.delAuths", roleId);
	}
	
	/**
	 * 获取角色权限
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RoleMenuBean> getRoleAuths(String roleId){
		return dao.queryForList("ROLE_AUTH.getRoleAuthorityTree",roleId);
	}
	
	/**
	 * 获取权限生成的树
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AuthorityBean> getAuTree(){
		return dao.queryForList("authority.getAuthorityTree");
	}
	
}
