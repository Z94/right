package com.right.entity;

public class Org {
    private Integer org_id;

    private String org_name;

    private Integer org_order;

    private Integer up_org_id;

	public Integer getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public Integer getOrg_order() {
		return org_order;
	}

	public void setOrg_order(Integer org_order) {
		this.org_order = org_order;
	}

	public Integer getUp_org_id() {
		return up_org_id;
	}

	public void setUp_org_id(Integer up_org_id) {
		this.up_org_id = up_org_id;
	}

}