package com.right.dao;

import java.util.List;
import java.util.Map;

import com.right.entity.UserFun;

public interface UserFunMapper {
    int insert(UserFun record);

    int insertSelective(UserFun record);

	List<Map<String, Object>> getMap(String id);
}