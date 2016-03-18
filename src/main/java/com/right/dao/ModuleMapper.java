package com.right.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;

public interface ModuleMapper {

	Module getModule(String id);

	List<Module> getModuleList();

	List<Map<String, Object>> getModuleHashMap();

	List<Map<String, Object>> getMap();
	List<Map<String, Object>> getMap00(String sql);

	List<Map<String, Object>> getMap2();

	List<Map<String, Object>> getManagerMap();

	int add(Module module);

	void add(String module_name, int module_order);
	
	List<String> getManager_id(@Param("org_id")List<Integer> org_id, @Param("loginId")String loginId, @Param("module_id")int module_id);
	List<Manager> getManager_name(List<String> list);
	List<Manager> getManagerList(@Param("org_id")List<Integer> org_id, @Param("lis")List<String> list);
	

	List<String> getRole_id(@Param("org_id")List<Integer> org_id, @Param("loginId")String loginId, @Param("module_id")int module_id);
	List<Role> getRole_name(List<String> list);
	List<Role> getRoleList(@Param("org_id")List<Integer> org_id, @Param("lis")List<String> list);

	List<String> getUser_id(@Param("org_id")List<Integer> org_id,@Param("loginId") String loginId, @Param("module_id")int module_id);
	List<User> getUser_name(List<String> list);
	List<User> getUserList(@Param("org_id")List<Integer> org_id, @Param("lis")List<String> list);

	int update(Module module);


}
