package com.right.dao;

import java.util.List;
import java.util.Map;

import com.right.entity.FManager;

public interface FManagerMapper {
    int insert(FManager record);

    int insertSelective(FManager record);

	List<Map<String, Object>> getManagerMap(String id);
}