package com.ncs.amaretto.cloud.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Role {

	@JsonProperty("RoleName")
	private String roleName;

	@JsonProperty("RoleID")
	private int roleID;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	

}
