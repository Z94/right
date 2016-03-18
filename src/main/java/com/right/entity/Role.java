package com.right.entity;

public class Role {
    private Integer role_id;

    private Integer org_id;

    private String role_name;

    private String role_describe;

    private Integer role_order;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_describe() {
		return role_describe;
	}

	public void setRole_describe(String role_describe) {
		this.role_describe = role_describe;
	}

	public Integer getRole_order() {
		return role_order;
	}

	public void setRole_order(Integer role_order) {
		this.role_order = role_order;
	}

 
}