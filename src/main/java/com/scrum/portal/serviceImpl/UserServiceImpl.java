package com.scrum.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.User;
import com.scrum.portal.repositories.UserRepository;
import com.scrum.portal.services.UserService;

@Service
public class UserServiceImpl implements UserService 
{

	@Autowired
	private UserRepository userRespository;
	
	@Override
	public void save(User user) 
	{
		
		userRespository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return userRespository.findByUserNameAndPassword(userName,password);
	}

	@Override
	public User update(User user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findUserByRoleId(int roleId) {
		return userRespository.findUserByroleID(roleId);
	}
	

}
