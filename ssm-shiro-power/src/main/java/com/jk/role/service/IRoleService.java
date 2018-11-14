package com.jk.role.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface IRoleService {

	List<LinkedHashMap<String, Object>> findRoleTree();

	void updateRoleByUserId(String ids, String userId);


}
