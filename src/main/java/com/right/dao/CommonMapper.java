package com.right.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.right.entity.FManager;
import com.right.entity.Manager;
import com.right.entity.Org;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface CommonMapper {

	List<Map<String, Object>> getMap();

	Org getOrg(String id);


	List<Integer> getOrg_id(String loginId);

	int delete(@Param("tableName")String tableName, @Param("id")int id, @Param("deleteName")String deleteName);

	int add(@Param("list")String[] ids, @Param("tableName")String tableName, @Param("id")int id,@Param("deleteName") String deleteName);

	List<Integer> getIds(@Param("tableName")String tableName, @Param("names")String[] names, @Param("selectName")String selectName);

	List<Integer> getOrgId(String loginId);

	

}
