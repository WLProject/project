package com.compass.role.controller;
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

import com.compass.role.model.RoleBean;
import com.compass.role.service.RoleService;
import com.compass.utils.CommonDate;
import com.compass.utils.ConstantUtils;
import com.compass.utils.mvc.AjaxReturnInfo;

/**
 * @author wangyuchao
 * 
 */
@Controller
@RequestMapping("/role/role.do")
public class RoleController {
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;

	/**
	 * 获取角色生成下拉框
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=getRoles")
	@ResponseBody
	public List<Map<String, Object>> getRoles(HttpServletRequest request) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<RoleBean> rolelist = roleService.getRoles("");
		String flag = request.getParameter("flag");
		//如果参数为1 添加   ”请选择记录“
		if ("1".equals(flag)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", ConstantUtils.COMBOXONEID);
			map.put("text", "请选择角色");
			map.put("selected", true);
			list.add(map);
		}
		for (int i = 0; i < rolelist.size(); i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("id", rolelist.get(i).getRoleId());
			map1.put("text", rolelist.get(i).getRoleName());
			list.add(map1);
		}
		return list;
	}
	/**
	 * 获取角色树
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=gettreeRole")
	@ResponseBody
	public List<Map<String,Object>> gettreeRole(HttpServletRequest request){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> clist = new ArrayList<Map<String, Object>>();
		List<RoleBean> rolelist = roleService.getRoles("");
		for(int i=0;i<rolelist.size();i++){
			Map<String, Object> map1 = new HashMap<String, Object>();
			if(i==0){
				map1.put("id", rolelist.get(i).getRoleId());
				map1.put("text", rolelist.get(i).getRoleName());
				map1.put("checked", true);
			}else{
				map1.put("id", rolelist.get(i).getRoleId());
				map1.put("text", rolelist.get(i).getRoleName());
			}
		
			list.add(map1);
		}		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",1);
		map.put("text", "根节点");
		map.put("children", list);
		clist.add(map);
		return clist;
	}

	/**
	 * 获取角色信息
	 * @param roleName
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=getRole")
	@ResponseBody
	public Map<String, Object> getRole(
			@RequestParam(value = "roleName") String roleName,
			@RequestParam(value = "status") String status,
			HttpServletRequest request) {
		List<RoleBean> list = roleService.getRole(roleName, status);
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		int pagenumber = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		int rownumber = Integer.parseInt((rows == "0" || rows == null) ? "20"
				: rows);
		int start = (pagenumber - 1) * rownumber;
		int end = (start + rownumber) > list.size() ? list.size() : start + rownumber;
		List<RoleBean> menulist=new ArrayList<RoleBean>();
		if (list != null && list.size() > 0) {
			for(int i=start;i<end;i++){
				menulist.add(list.get(i));
			}
		}
		
		return AjaxReturnInfo.setTable(list==null?0:list.size(), list);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=getRolecom")
	@ResponseBody
	public Map<String, Object> getRolecom() {
	
		
		List<RoleBean> list = roleService.getRole("", "1");
		return AjaxReturnInfo.setTable(list.size(), list);
	}

	/**
	 * 添加角色信息
	 * @param roleName
	 * @param Status
	 * @param roleDesc
	 * @param roletypeId
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=addRole")
	@ResponseBody
	public AjaxReturnInfo addRole(
			@RequestParam(value = "roleName") String roleName,
			@RequestParam(value = "Status") String Status,
			@RequestParam(value = "roleDesc") String roleDesc,
			@RequestParam(value = "roletypeId") String roletypeId,
			HttpServletRequest request) {
		String createId=request.getSession().getAttribute(ConstantUtils.USERID)+"";
		RoleBean rb = new RoleBean();
		rb.setRoleName(roleName);
		rb.setStatus(Status);
		rb.setRoletypeId(roletypeId);
		rb.setRoleDesc(roleDesc);
		rb.setCreateId(createId);
		//String roleId=CommonTable.getTableId("r");
		String roleId=roleService.getseqRoleId().toString();
		String createDt=CommonDate.getDate();
		rb.setRoleId(roleId);
		rb.setCreateDt(createDt);
		int result = roleService.add(rb);
		AjaxReturnInfo ajaxinfo = null;
		if (result == 0) {
			ajaxinfo = AjaxReturnInfo.failed("保存失败");
		} else {
			ajaxinfo = AjaxReturnInfo.success("保存成功");
		}
		return ajaxinfo;
	}

	/**
	 * 修改角色信息
	 * @param roleName
	 * @param Status
	 * @param roleDesc
	 * @param roleId
	 * @param roletypeId
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=updateRole")
	@ResponseBody
	public AjaxReturnInfo updateRole(
			@RequestParam(value = "roleName") String roleName,
			@RequestParam(value = "Status") String Status,
			@RequestParam(value = "roleDesc") String roleDesc,
			@RequestParam(value = "roleId") String roleId,
			@RequestParam(value = "roletypeId") String roletypeId,
			HttpServletRequest request) {
		String createId=request.getSession().getAttribute(ConstantUtils.USERID)+"";
		String createDt=CommonDate.getDate();
		RoleBean rb = new RoleBean();
		rb.setRoleId(roleId);
		rb.setRoleName(roleName);
		rb.setStatus(Status);
		rb.setRoletypeId(roletypeId);
		rb.setRoleDesc(roleDesc);
		rb.setModifyid(createId);
		rb.setModifydt(createDt);
		int result = roleService.update(rb);
		AjaxReturnInfo ajaxinfo = null;
		if (result == 0) {
			ajaxinfo = AjaxReturnInfo.failed("修改失败");
		} else {
			ajaxinfo = AjaxReturnInfo.success("修改成功");
		}
		return ajaxinfo;
	}

	/**
	 * 删除角色信息
	 * @param Ids
	 * @return
	 */
	@RequestMapping(params = "method=deleteRole")
	@ResponseBody
	public AjaxReturnInfo deleteRole(@RequestParam(value = "Ids") String Ids) {
		AjaxReturnInfo ajaxinfo = null;
		int result = roleService.delete(Ids);
		if (result == 0) {
			ajaxinfo = AjaxReturnInfo.failed("删除失败");
		} else {
			ajaxinfo = AjaxReturnInfo.success("删除成功");
		}
		
		return ajaxinfo;
	}

	
}
