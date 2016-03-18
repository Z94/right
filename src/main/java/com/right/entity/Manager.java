package com.right.entity;

public class Manager {
    private String manager_id;

    private Integer org_id;

    private String manager_name;

    private String manager_login;

    private String manager_pwd;

    private Integer manager_order;

    private Short manager_control;

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id == null ? null : manager_id.trim();
	}

	public Integer getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Integer org_id) {
		this.org_id = org_id ;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name == null ? null : manager_name.trim();
	}

	public String getManager_login() {
		return manager_login;
	}

	public void setManager_login(String manager_login) {
		this.manager_login = manager_login == null ? null : manager_login.trim();
	}

	public String getManager_pwd() {
		return manager_pwd;
	}

	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd == null ? null : manager_pwd.trim();
	}

	public Integer getManager_order() {
		return manager_order;
	}

	public void setManager_order(Integer manager_order) {
		this.manager_order = manager_order;
	}

	public Short getManager_control() {
		return manager_control;
	}

	public void setManager_control(Short manager_control) {
		this.manager_control = manager_control;
	}
	
	

}