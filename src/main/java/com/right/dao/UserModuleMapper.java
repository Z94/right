package com.right.dao;

import java.util.List;
import java.util.Map;

import com.right.entity.UserModule;

public interface UserModuleMapper {
    int insert(UserModule record);

    int insertSelective(UserModule record);

	List<Map<String, Object>> getMap(String userId);
}