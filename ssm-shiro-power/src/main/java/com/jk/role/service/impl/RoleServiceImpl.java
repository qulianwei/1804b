package com.jk.role.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.role.mapper.RoleMapper;
import com.jk.role.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<LinkedHashMap<String, Object>> findRoleTree() {
		return roleMapper.findRoleTree();
	}
	
	@Override
	public void updateRoleByUserId(String ids, String userId) {
		roleMapper.deleteRoleByUserId(userId);
		if (ids.contains(",")) {
			roleMapper.updateRoleByUserId(ids.split(","),userId);
		}else{
			roleMapper.updateRoleByUserId1(ids,userId);
		}
		
	}
	
	
	
	
	
	
	

}
