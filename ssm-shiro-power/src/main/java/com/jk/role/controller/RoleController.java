package com.jk.role.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.role.service.IRoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("findRoleTree")
	@ResponseBody
	public List<LinkedHashMap<String,Object>> findRoleTree(){
		return roleService.findRoleTree();
	}
	
	@RequestMapping("updateRoleByUserId")
	@ResponseBody
	public void updateRoleByUserId(String ids,String userId){
		
			roleService.updateRoleByUserId(ids,userId);	
	}
	
	

}
