package com.jk.user.mapper;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.role.model.UserRole;
import com.jk.user.model.User;

public interface UserMapper {

	List<User> queryUserList(@Param("name")String name);

	List<UserRole> queryRoleByUserId(@Param("userId")String userId);

	List<LinkedHashMap<String, Object>> findTree(@Param("userName")String userName);

}
