package com.right.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.right.entity.Function;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

	List<User> getUserList(String userName);

	User getUser(String userName);

	User getUser1(String id);
	
	
	List<String> getFunctionList(int user_id);
	List<Function> getFunction_name(List<String> list);
	List<String> getFunction_id(@Param("loginId")String loginId, @Param("list")List<String> list);
	
	List<String> getModuleList(int user_id);
	List<Module> getModule_name(List<String> list);
	List<String> getModule_id(@Param("loginId")String loginId, @Param("list")List<String> list);

	List<String> getRoleList(int user_id);
	List<Role> getRole_name(List<Integer> role_id);
	List<Integer> getRole_id(@Param("list")List<String> list, @Param("org_id")List<Integer> org_id);
	List<Integer> getOrg_id(int user_id);

	List<Role> getRole_name1(List<String> list);

	int update(User user);

}