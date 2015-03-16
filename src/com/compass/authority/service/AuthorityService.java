/**
 * 
 */
package com.compass.authority.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.compass.authority.model.AuthorityBean;
import com.compass.utils.AbstractService;

/**
 * @author wangYuChao
 * 
 */
public class AuthorityService extends AbstractService {
	/**
	 * 获取菜单编号
	 * @return
	 */
	public Integer getMenuId(){
		return (Integer) dao.queryForObject("SEQUENCE.getMenuId");
	}
	
	/**
	 * 根据条件查询菜单
	 * @param powerName
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<AuthorityBean> getAuthority (String powerName, String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuName", powerName);
		map.put("menuStatus", status);
		return dao.queryForList("authority.getAuthority", map);
	}

	/**
	 * 添加菜单方法
	 * @param authorityBean
	 * @return
	 */
	public int add(AuthorityBean authorityBean) {
		return dao.insert("authority.addAuthority", authorityBean);
	}

	/**
	 * 修改菜单方法
	 * @param authorityBean
	 * @return
	 */
	public int update(AuthorityBean authorityBean) {
		return dao.update("authority.updateAuthority", authorityBean);
	}

	/**
	 * 删除菜单方法
	 * @param menuId
	 * @return
	 */
	public int delete(String menuId) {
		return dao.update("authority.deleteAuthority", menuId);
	}

	/**
	 * 获得所有菜单，生成树使用
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AuthorityBean> getAuTree(){
		return dao.queryForList("authority.getAuthorityTree");
	}
	
	/**
	 * 获得所有根菜单的直接子菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AuthorityBean> getParentMenu(){
		return dao.queryForList("authority.getParentMenu");
	}
}
