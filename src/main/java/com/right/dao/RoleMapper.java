package com.right.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.right.entity.Function;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);

	List<Map<String, Object>> getMap();

	Role getRole(String id);
	
	
	List<String> getFunctionList(int role_id);
	List<Function> getFunction_name(List<String> list);
	List<String> getFunction_id(@Param("loginId")String loginId, @Param("list")List<String> list);
	
	List<Integer> getModuleList(int role_id);
	List<Module> getModule_name(List<Integer> list);
	List<Integer> getModule_id(@Param("loginId")String loginId, @Param("list")List<Integer> list);

	List<String> getUserList(int role_id);
	List<User> getUser_name(List<String> list);
	List<String> getUser_id(@Param("list")List<String> list, @Param("org_id")List<Integer> org_id);
	List<Integer> getOrg_id(int role_id);

	int update(Role role);
}