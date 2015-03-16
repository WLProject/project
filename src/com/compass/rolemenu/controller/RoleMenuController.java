package com.compass.rolemenu.controller;

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

import com.compass.authority.model.AuthorityBean;
import com.compass.rolemenu.model.RoleMenuBean;
import com.compass.rolemenu.service.RoleMenuService;
import com.compass.utils.CommonDate;
import com.compass.utils.ConstantUtils;
import com.compass.utils.mvc.AjaxReturnInfo;
/**
 * 
 * @author wangLong
 *
 */

@Controller
@RequestMapping("/role_auth/role_auth.do")
public class RoleMenuController {

	@Autowired
	@Qualifier("roleMenuService")
	private RoleMenuService roleMenuService;
	/**
	 *  查看角色所对应的菜单，并生成树
	 * @param roleId
	 * @return
	 */
	@RequestMapping(params = "method=getRoleAuthsTree")
	@ResponseBody
	public List<Map<String, Object>> getRoleAuthTree(
			@RequestParam(value = "roleId") String roleId) {
		List<RoleMenuBean> list = roleMenuService.getRoleAuths(roleId);//角色的所有菜单
		List<AuthorityBean> auslist = roleMenuService.getAuTree();//所有菜单
		return createAuthTree(list, auslist, "-1");
	}
	/**
	 * 查看角色所对应的菜单，并生成树（提取方法便于递归查找）
	 * @param list
	 * @param auslist
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> createAuthTree(List<RoleMenuBean> list,
			List<AuthorityBean> auslist, String id) {
		List<Map<String, Object>> aulist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < auslist.size(); i++) {
			Map<String, Object> map = null;
			AuthorityBean at = auslist.get(i);
			if (id.equals(at.getParentNodeId())) {
				map = new HashMap<String, Object>();
				map.put("id", at.getMenuId());
				map.put("text", at.getMenuName());
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getAuthId()
							.equals(auslist.get(i).getMenuId())) {
						map.put("checked", true);
					}
				}
				if ("0".equals(at.getChildCode())) {
					map.put("state", "open");
				} else {
					map.put("state", "open");
					map.put("children",
							createAuthTree(list, auslist, at.getMenuId()));

				}

			}
			if (map != null)
				aulist.add(map);
		}
		return aulist;
	}
	/**
	 * 删除角色对应的菜单
	 * @param roleId
	 * @return
	 */
	public AjaxReturnInfo delPowers(
			@RequestParam(value = "roleId") String roleId) {
		int result = 0;
		result = roleMenuService.delAuths(roleId);
		AjaxReturnInfo ajaxInfo = AjaxReturnInfo.success("操作成功");
		if (result == 0) {
			ajaxInfo = AjaxReturnInfo.failed("操作失败");
		}
		return ajaxInfo;
	}
	/**
	 * 保存角色对应的菜单
	 * @param powerIds
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=saveAuths")
	@ResponseBody
	public AjaxReturnInfo savePowers(
			@RequestParam(value = "powerIds") String powerIds,
			@RequestParam(value = "roleId") String roleId,
			HttpServletRequest request) {
		int result = 0;
		delPowers(roleId);
		AjaxReturnInfo ajaxReturnInfo = AjaxReturnInfo.success("保存成功");
		if(!"".equals(powerIds)){
			String ids[] = powerIds.split(",");
			for (String powerId : ids) {
				RoleMenuBean rmb = new RoleMenuBean();
				String createId=request.getSession().getAttribute(ConstantUtils.USERID).toString();
				String createDt=CommonDate.getDate();
				rmb.setRoleId(roleId);
				rmb.setAuthId(powerId);
				rmb.setCreateId(createId);
				rmb.setCreateDt(createDt);
				
				result = roleMenuService.saveAuths(rmb);
			}
		
			if (result == 0) {
				ajaxReturnInfo = AjaxReturnInfo.failed("保存失败");
			}
		}
		return ajaxReturnInfo;
	}

}
