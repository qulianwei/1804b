package com.jk.user.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.jk.role.model.UserRole;
import com.jk.user.model.User;

public interface IUserService {

	List<User> queryUserList(String name);

	List<UserRole> queryRoleByUserId(String userId);

	List<LinkedHashMap<String, Object>> findTree(String userName);

}
