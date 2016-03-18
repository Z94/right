package com.right.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.metadata.Database;
import org.apache.ibatis.metadata.Table;
import org.springframework.stereotype.Service;

import com.right.dao.CommonMapper;
import com.right.dao.ModuleMapper;
import com.right.entity.FManager;
import com.right.entity.Manager;
import com.right.entity.Module;
@Service
public class CommonService {

	@Resource
	CommonMapper cdao;

public List<Integer> getOrg_id(String loginId) {
	return cdao.getOrg_id(loginId);
}

public int delete(String tableName, int id, String deleteName) {
	return cdao.delete(tableName,id,deleteName);
}

public int add(String[] ids,String tableName, int id, String deleteName) {
	return cdao.add(ids,tableName,id,deleteName);
}

public List<Integer> getIds(String tableName, String[] names, String deleteName) {
	return cdao.getIds(tableName,names,deleteName);
}

public List<Integer> getOrgId(String loginId) {
	return cdao.getOrgId(loginId);
}



}
