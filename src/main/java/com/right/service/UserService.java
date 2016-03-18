package com.right.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.UserMapper;
import com.right.entity.Function;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;

@Service
public class UserService {

	@Resource
	UserMapper dao;
	public List<String> getModuleList(int user_id) {
		return dao.getModuleList(user_id);
	}
	public List<Module> getModule_name(List<String> list) {
		if (!list.isEmpty()) {
			return dao.getModule_name(list);
		}else {
			return null;
		}
		
	}
	public List<String> getModule_id(String loginId, List<String> list) {
		return dao.getModule_id(loginId,list);
	}


	public List<String> getFunctionList(int user_id) {
		return dao.getFunctionList(user_id);
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
	
	
	public List<String> getRoleList(int user_id) {
		return dao.getRoleList(user_id);
	}
	public List<Role> getRole_name(List<Integer> role_id) {
		if (!role_id.isEmpty()) {
			return dao.getRole_name(role_id);
		}else {
			return null;
		}
		
	}
	public List<Integer> getRole_id(List<String> list, List<Integer> org_id) {
		return dao.getRole_id(list,org_id);
	}
	public List<Integer> getOrg_id(int user_id) {
		return dao.getOrg_id(user_id);
	}
	public List<Role> getRole_name1(List<String> list) {
		if (!list.isEmpty()) {
			return dao.getRole_name1(list);
		}else {
			return null;
		}
	}
	public int add(User user) {
		return dao.insert(user);
	}
	public int update(User user) {
		return dao.update(user);
	}
}
