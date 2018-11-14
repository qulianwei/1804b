package com.jk.user.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.role.model.UserRole;
import com.jk.user.mapper.UserMapper;
import com.jk.user.model.User;
import com.jk.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> queryUserList(String name) {

		List<User> list=userMapper.queryUserList(name);

		return list;
	}
	
	
	@Override
	public List<UserRole> queryRoleByUserId(String userId) {
		return userMapper.queryRoleByUserId(userId);
	}
	
	@Override
	public List<LinkedHashMap<String, Object>> findTree(String userName) {
		return userMapper.findTree(userName);
	}
	
	
	

}
