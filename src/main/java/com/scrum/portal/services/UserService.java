package com.scrum.portal.services;

import java.util.List;

import com.scrum.portal.dto.User;



public interface UserService 
{
	public void save(User user);
	
	public List<User> findAll();

	public User findOne(int id);

	public User findByUserNameAndPassword(String userName, String password);

	public User update(User user, int id);

	public void delete(int id);
	
	public List<User> findUserByRoleId(int roleId);

}

