package com.right.dao;

import java.util.List;
import java.util.Map;

import com.right.entity.MManager;

public interface MManagerMapper {
    int insert(MManager record);

    int insertSelective(MManager record);

	List<Map<String, Object>> getMap();

	List<Map<String, Object>> getManagerMap(String managerId);
}