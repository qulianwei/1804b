package com.jk.role.mapper;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

	List<LinkedHashMap<String, Object>> findRoleTree();

	void deleteRoleByUserId(@Param("userId")String userId);

	void updateRoleByUserId(@Param("ids")String[] ids, @Param("userId")String userId);

	void updateRoleByUserId1(@Param("ids")String ids, @Param("userId")String userId);

}
