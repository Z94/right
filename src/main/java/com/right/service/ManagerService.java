package com.right.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.ManagerMapper;
import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;

@Service
public class ManagerService {

	@Resource
	ManagerMapper dao;
	public List<Integer> getFunctionList(int manager_id) {
		return dao.getFunctionList(manager_id);
	}
	public List<Function> getFunction_name(List<Integer> list) {
		if (!list.isEmpty()) {

			return dao.getFunction_name(list);
		}else {
			return null;
		}
	}
	public List<Integer> getFunction_id(String loginId, List<Integer> list) {
		return dao.getFunction_id(loginId,list);
	}
	
	public List<String> getModuleList(String manager_id) {
		return dao.getModuleList(manager_id);
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
	public int add(Manager manager) {
		return dao.insert(manager);
	}
	public int update(Manager manager) {
		return dao.update(manager);
	}

}
