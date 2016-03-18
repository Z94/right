package com.right.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.right.dao.ManagerMapper;
import com.right.dao.ModuleMapper;
import com.right.dao.UserMapper;
import com.right.entity.Manager;
import com.right.entity.User;

@Service
public class LoginService {

	@Resource
	ManagerMapper mdao;
	
	@Resource
	UserMapper udao;
	
	@Resource
	ModuleMapper modao;

	public List<User> getUserList(String userName) {
		return udao.getUserList( userName);
	}

	public Manager getManager(String userName) {
		return mdao.getManager(userName);
	}

	public User getUser(String userName) {
		return udao.getUser(userName);
	}

	public List<Map<String, Object>> getMap() {
		return modao.getMap();
	}

	public List<Manager> getManagerList() {
		return mdao.getManagerList();
	}

}
