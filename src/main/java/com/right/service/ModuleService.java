package com.right.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.ModuleMapper;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;

@Service
public class ModuleService {

	@Resource
	ModuleMapper dao;
	public List<String> getManager_id(List<Integer> org_id, String loginId, int module_id) {
		return dao.getManager_id(org_id,loginId,module_id);
	}
	public List<Manager> getManager_name(List<String> list) {
		return dao.getManager_name(list);
	}
	public List<Manager> getManagerList(List<Integer> org_id, List<String> list) {
		return dao.getManagerList(org_id,list);
	}
	
	
	public List<String> getRole_id(List<Integer> org_id, String loginId, int module_id) {
		return dao.getRole_id(org_id,loginId,module_id);
	}
	public List<Role> getRole_name(List<String> list) {
		return dao.getRole_name(list);
	}
	public List<Role> getRoleList(List<Integer> org_id, List<String> list) {
		return dao.getRoleList(org_id,list);
	}


	public List<String> getUser_id(List<Integer> org_id, String loginId, int module_id) {
		return dao.getUser_id(org_id,loginId,module_id);
	}


	public List<User> getUser_name(List<String> list) {
		return dao.getUser_name(list);
	}


	public List<User> getUserList(List<Integer> org_id, List<String> list) {
		return dao.getUserList(org_id,list);
	}
	public int add(Module module) {
		return dao.add(module);
	}
	public int update(Module module) {
		return dao.update(module);
	}
}
