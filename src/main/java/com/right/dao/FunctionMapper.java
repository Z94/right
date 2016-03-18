package com.right.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.right.entity.FManager;
import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Role;
import com.right.entity.User;

public interface FunctionMapper {
    int insert(Function record);

    int insertSelective(Function record);

	List<Map<String, Object>> getMap();

	List<Map<String, Object>> getManagerMap();

	Function getFunction(String id);

	List<Function> getFunctionList();
	
	List<Integer> getManager_id(@Param("org_id")List<Integer> org_id, @Param("loginId")String loginId, @Param("function_id")int function_id);
	List<Manager> getManager_name(List<Integer> list);
	List<Manager> getManagerList(@Param("orgId")List<Integer> org_id, @Param("lis")List<Integer> list);
	

	List<Integer> getRole_id(@Param("org_id")List<Integer> org_id, @Param("loginId")String loginId, @Param("function_id")int function_id);
	List<Role> getRole_name(List<Integer> list);
	List<Role> getRoleList(@Param("org_id")List<Integer> org_id, @Param("lis")List<Integer> list);

	List<Integer> getUser_id(@Param("org_id")List<Integer> org_id,@Param("loginId") String loginId, @Param("function_id")int function_id);
	List<User> getUser_name(List<Integer> list);
	List<User> getUserList(@Param("org_id")List<Integer> org_id, @Param("lis")List<Integer> list);

	int add(Function function);

	int update(Function function);

	void delete1(int function_id);
	void add1(List<FManager> fms);

	void add2(@Param("manager_id") String[] manager_id, @Param("function_id")int function_id);
}