package com.right.dao;

import java.util.List;
import java.util.Map;

import com.right.entity.Org;

public interface OrgMapper {


    int insert(Org record);

    int insertSelective(Org record);
	String getOrgName(String userOrgId);
	Org getOrg(String userOrgId);

	List<Map<String, Object>> getMap();

	List<Org> getOrgList();

	int add(Org org);

	int update(Org org);

}
