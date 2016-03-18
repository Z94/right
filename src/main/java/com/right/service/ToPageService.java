package com.right.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.CommonMapper;
import com.right.dao.FunctionMapper;
import com.right.dao.ManagerMapper;
import com.right.dao.ModuleMapper;
import com.right.dao.OrgMapper;
import com.right.dao.RoleMapper;
import com.right.dao.UserMapper;
import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Org;
import com.right.entity.Role;
import com.right.entity.User;

@Service
public class ToPageService {

	@Resource
	ModuleMapper mdao;
	public Module getModule(String id) {
		return mdao.getModule(id);
	}
	public List<Module> getModuleList() {
		return mdao.getModuleList();
	}
	
	@Resource
	CommonMapper cdao;
	public Org getOrg(String id) {
		return cdao.getOrg(id);
	}
	
	@Resource
	RoleMapper rdao;
	public Role getRole(String id) {
		return rdao.getRole(id);
	}
	
	@Resource
	FunctionMapper fdao;
	public Function getFunction(String id) {
		return fdao.getFunction(id);
	}
	public List<Function> getFunctionList() {
		return fdao.getFunctionList();
	}
	
	@Resource
	ManagerMapper madao;
	public Manager getManager(String id) {
		return madao.getManager1(id);
	}
	
	@Resource
	UserMapper udao;
	public User getUser(String id) {
		return udao.getUser1(id);
	}
	
	@Resource
	OrgMapper odao;
	public List<Org> getOrgList() {
		return odao.getOrgList();
	}
	public int add(Org org) {
		return odao.add(org);
	}
	public int update(Org org) {
		return odao.update(org);
	}
	
	

}
