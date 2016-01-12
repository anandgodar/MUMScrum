package com.scrum.portal.model;

import java.util.ArrayList;
import java.util.List;



import com.scrum.portal.enumeration.Role;


public class UserRoleFormBean { 
	

	private int role_id;
	
	private String name;
	
	
	private List<UserFormBean> users = new ArrayList<UserFormBean>();
	
	
	public List<UserFormBean> getUsers() {
		return users;
	}
	public void setUsers(List<UserFormBean> users) {
		this.users = users;
	}
	
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(Role userRole) {
		this.name = userRole.name();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
