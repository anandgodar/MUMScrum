package com.scrum.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("")
	public User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
	
	
	public List<User> findUserByroleID(@Param("roleID") int roleID);
  
}
