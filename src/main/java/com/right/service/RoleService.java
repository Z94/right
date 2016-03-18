package com.right.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.RoleMapper;
import com.right.entity.Function;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;

@Service
public class RoleService {

	@Resource
	RoleMapper dao;
//role_module	
	public List<Integer> getModuleList(int role_id) {
		return dao.getModuleList(role_id);
	}
	public List<Module> getModule_name(List<Integer> list) {
		if (!list.isEmpty()) {
			return dao.getModule_name(list);
		}else {
			return null;
		}
		
	}
	public List<Integer> getModule_id(String loginId, List<Integer> list) {
		return dao.getModule_id(loginId,list);
	}

//role_function	
	public List<String> getFunctionList(int role_id) {
		return dao.getFunctionList(role_id);
	}
	public List<Function> getFunction_name(List<String> list) {
		if (!list.isEmpty()) {

			return dao.getFunction_name(list);
		}else {
			return null;
		}
	}
	public List<String> getFunction_id(String loginId, List<String> list) {
		return dao.getFunction_id(loginId,list);
	}
	
//role_user	
	public List<String> getUserList(int role_id) {
		return dao.getUserList(role_id);
	}
	public List<User> getUser_name(List<String> list) {
		if (!list.isEmpty()) {
			return dao.getUser_name(list);
		}else {
			return null;
		}
		
	}
	public List<String> getUser_id(List<String> list, List<Integer> org_id) {
		return dao.getUser_id(list,org_id);
	}
	public List<Integer> getOrg_id(int role_id) {
		return dao.getOrg_id(role_id);
	}
	public int add(Role role) {
		return dao.insert(role);
	}
	public int update(Role role) {
		return dao.update(role);
	}
}
