package com.scrum.portal.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.scrum.portal.enumeration.Role;

//@Entity
//@Table(name = "role")
public class UserRole { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int role_id;
	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinColumn(name = "id")
	private List<User> users = new ArrayList<User>();
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
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
