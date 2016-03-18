package com.right.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.FunctionMapper;
import com.right.entity.FManager;
import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Role;
import com.right.entity.User;

@Service
public class FunctionService {

	@Resource
	FunctionMapper dao;
	public List<Integer> getManager_id(List<Integer> org_id, String loginId, int function_id) {
		return dao.getManager_id(org_id,loginId,function_id);
	}
	public List<Manager> getManager_name(List<Integer> list) {
		if (!list.isEmpty()) {

			return dao.getManager_name(list);
		}else {
			return null;
		}
	}
	public List<Manager> getManagerList(List<Integer> org_id, List<Integer> list) {
		return dao.getManagerList(org_id,list);
	}
	
	
	public List<Integer> getRole_id(List<Integer> org_id, String loginId, int function_id) {
		return dao.getRole_id(org_id,loginId,function_id);
	}
	public List<Role> getRole_name(List<Integer> list) {
		if (!list.isEmpty()) {

			return dao.getRole_name(list);
		}else {
			return null;
		}
	}
	public List<Role> getRoleList(List<Integer> org_id, List<Integer> list) {
		return dao.getRoleList(org_id,list);
	}


	public List<Integer> getUser_id(List<Integer> org_id, String loginId, int module_id) {
		return dao.getUser_id(org_id,loginId,module_id);
	}


	public List<User> getUser_name(List<Integer> list) {
		return dao.getUser_name(list);
	}


	public List<User> getUserList(List<Integer> org_id, List<Integer> list) {
		return dao.getUserList(org_id,list);
	}
	public int add(Function function) {
		return dao.add(function);
	}
	public int update(Function function) {
		return dao.update(function);
	}
	public void delete1(int function_id) {
		dao.delete1(function_id);
	}
	public void add1(List<FManager> fms) {
		 dao.add1(fms);
	}
	public void add2(String[] manager_id, int function_id) {
		dao.add2(manager_id,function_id);
	}
}
