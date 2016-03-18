package com.right.dao;

import java.util.List;
import java.util.Map;

import com.right.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

	List<Map<String, Object>> getMap(String id);
}