package com.right.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;

public interface ManagerMapper {
    int insert(Manager record);

    int insertSelective(Manager record);

	List<Manager> getManagerList();

	Manager getManager(String userName);

	List<Map<String, Object>> getMap();

	Manager getManager1(String id);

	List<Integer> getFunctionList(int manager_id);
	List<Function> getFunction_name(List<Integer> list);
	List<Integer> getFunction_id(@Param("loginId")String loginId, @Param("list")List<Integer> list);
	
	List<String> getModuleList(String manager_id);
	List<Module> getModule_name(List<String> list);
	List<String> getModule_id(@Param("loginId")String loginId, @Param("list")List<String> list);

	int update(Manager manager);


}