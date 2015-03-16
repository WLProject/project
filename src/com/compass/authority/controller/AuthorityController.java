package com.compass.authority.controller;
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
import com.compass.authority.service.AuthorityService;
import com.compass.utils.CommonDate;
import com.compass.utils.ConstantUtils;
import com.compass.utils.mvc.AjaxReturnInfo;
@Controller
@RequestMapping("/authority/authority.do")
public class AuthorityController {
	@Autowired
	@Qualifier("authorityService")
	private AuthorityService authorityService;
	
	/**
	 * 根据条件查询菜单
	 * @param powerName
	 * @param status
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "method=getAuthority")
	@ResponseBody
	public Map<String, Object> getAuthority(
			@RequestParam(value = "powerName") String powerName,
			@RequestParam(value = "status") String status,
			HttpServletRequest req) {
		String rows = req.getParameter("rows");
		String page = req.getParameter("page");
		List<AuthorityBean> list = authorityService.getAuthority(powerName,status);
		int pagenumber = Integer.parseInt((page == null || page == "0") ? "1": page);
		int rownumber = Integer.parseInt((rows == "0" || rows == null) ? "20": rows);
		int start = (pagenumber - 1) * rownumber;
		int end = (start + rownumber) > list.size() ? list.size() : start + rownumber;
		List<AuthorityBean> menulist=new ArrayList<AuthorityBean>();
		if (list != null && list.size() > 0) {
			for(int i=start;i<end;i++){
				menulist.add(list.get(i));
			}
		}
		
		return AjaxReturnInfo.setTable(list.size(), menulist);
	}
	/**
	 * 添加菜单功能
	 * @param powerName
	 * @param Status
	 * @param remark
	 * @param parentId
	 * @param menuUrl
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=addAuthority")
	@ResponseBody
	public AjaxReturnInfo addAuthority(
			@RequestParam(value = "powerName") String powerName,
			@RequestParam(value = "Status") String Status,
			@RequestParam(value = "comment") String comment,
			@RequestParam(value = "parentId") String parentId,
			@RequestParam(value = "menuUrl") String menuUrl,
			HttpServletRequest  request) {
		AuthorityBean ab = new AuthorityBean();
		String menuId=authorityService.getMenuId().toString();
		ab.setMenuName(powerName);
		ab.setMenuStatus(Status);
		ab.setMenuUrl(menuUrl);
		ab.setComment(comment);
		ab.setParentNodeId(parentId);
		ab.setMenuId(menuId);
		
		String createId=request.getSession().getAttribute(ConstantUtils.USERID).toString();
		ab.setCreateId(createId);
		ab.setCreateDt(CommonDate.getDate());
		int result = authorityService.add(ab);
		AjaxReturnInfo ajaxinfo = null;
		if (result == 0) {
			ajaxinfo = AjaxReturnInfo.failed("保存失败");
		} else {
			ajaxinfo = AjaxReturnInfo.success("保存成功");
		}
		return ajaxinfo;
	}

	/**
	 * 修改菜单功能
	 * @param powerName
	 * @param Status
	 * @param remark
	 * @param powerId
	 * @param menuUrl
	 * @param parentId
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=updateAuthority")
	@ResponseBody
	public AjaxReturnInfo updateAuthority(
			@RequestParam(value = "powerName") String powerName,
			@RequestParam(value = "Status") String Status,
			@RequestParam(value = "comment") String comment,
			@RequestParam(value = "powerId") String powerId,
			@RequestParam(value = "menuUrl") String menuUrl,
			@RequestParam(value = "parentId") String parentId,
			HttpServletRequest request) {
		AuthorityBean ab = new AuthorityBean();
		ab.setMenuName(powerName);
		ab.setMenuStatus(Status);
		ab.setComment(comment);
		ab.setMenuId(powerId);
		ab.setMenuUrl(menuUrl);
		ab.setParentNodeId(parentId);
		String createId=request.getSession().getAttribute(ConstantUtils.USERID)+"";
		ab.setOperator(createId);
		ab.setOperationTime(CommonDate.getDate());
		int result = authorityService.update(ab);
		AjaxReturnInfo ajaxinfo = null;
		if (result == 0) {
			ajaxinfo = AjaxReturnInfo.failed("修改失败");
		} else {
			ajaxinfo = AjaxReturnInfo.success("修改成功");
		}
		return ajaxinfo;
	}
	/**
	 * 删除菜单功能
	 * @param Ids
	 * @return
	 */
	@RequestMapping(params = "method=deleteAuthority")
	@ResponseBody
	public AjaxReturnInfo deleteAuthority(
			@RequestParam(value = "Ids") String Ids) { //ids 为多个ID 中间用','隔开
		AjaxReturnInfo ajaxinfo = null;
		int result = authorityService.delete(Ids);
		if (result == 0) {
			ajaxinfo = AjaxReturnInfo.failed("删除失败");
		} else {
			ajaxinfo = AjaxReturnInfo.success("删除成功");
		}
		return ajaxinfo;
	}

	/**
	 * 获得所有菜单并且生成树
	 * @return
	 */
	@RequestMapping(params = "method=getAuthTree")
	@ResponseBody
	public List<Map<String, Object>> getAuthTree() {
		List<AuthorityBean> list = authorityService.getAuTree();
		return createAuthTree(list, "-1");//-1为跟菜单的父节点，依据为数据库根菜单的 父菜单ID
	}
	/**
	 * 遍历所有数据拼接生成树形结构需要的json数据
	 * @param list
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> createAuthTree(List<AuthorityBean> list,
			String id) {
		List<Map<String, Object>> aulist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = null;
			AuthorityBean at = list.get(i);
			if (id.equals(at.getParentNodeId())) {
				map = new HashMap<String, Object>();
				map.put("id", at.getMenuId());
				map.put("text", at.getMenuName());
				if ("0".equals(at.getChildCode())) {
					map.put("state", "open");
				} else {
					map.put("state", "open");
					map.put("children", createAuthTree(list, at.getMenuId()));
				}
			}
			if (map != null)
				aulist.add(map);
		}
		return aulist;
	}
	
	/**
	 * 获取根菜单中的所有直属节点，供下拉框使用
	 * @return
	 */
	@RequestMapping(params = "method=getParentMenu")
	@ResponseBody
	public List<Map<String, Object>> getParentMenu() {
		List<AuthorityBean> list = authorityService.getParentMenu();
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();
		 Map<String,Object> map1=new HashMap<String,Object>();
		 map1.put("id",ConstantUtils.COMBOXONEID);
		 map1.put("text", "请选择上级菜单");
		 map1.put("selected", true);
		 maplist.add(map1); 
		for(int i=0;i<list.size();i++){
			Map<String ,Object> map=new HashMap<String ,Object>();
			map.put("id", list.get(i).getMenuId());
			map.put("text", list.get(i).getMenuName());
			maplist.add(map);
		}
		return maplist;
	}
	
}
