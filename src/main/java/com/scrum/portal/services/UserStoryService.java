package com.scrum.portal.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.model.UserStoryFormBean;

public interface UserStoryService {
	
	public List<ProductBackLogUserStory> findAll();
	public boolean createUserStory(UserStoryFormBean userStory) throws IllegalAccessException, InvocationTargetException;
	public ProductBackLogUserStory findUserStoryById(int id);
	public boolean updateUserStory(UserStoryFormBean userStory);
	public void delete(int id);
	/*boolean removeUserStoryFromProduct(ProductBackLogUserStory myUserStory)
			throws IllegalAccessException, InvocationTargetException;*/
	
	List<ProductBackLogUserStory> findUserStoryByProductId(int pid);
	List<ProductBackLogUserStory> findUnAssignedUserStoryByProductId(int pid);
	public void updateReleaseId(int id, int pid, int rid);
	public List<ProductBackLogUserStory> findUserStoryByreleaseId(int rid);
	
	List<ProductBackLogUserStory> findUnAssignedUserStoryBySprintId(int pid);
	public List<ProductBackLogUserStory> findUserStoryBySprintId( int sprintid);
	public void updateSprintId(int id, int pid, int sid);
	public void updateDeveloperAndTesterIdInUserStory(int uid, int did, int pid, String usertype);
	public List<ProductBackLogUserStory> findUserStoryByDeveloperId(int did,String usertype);
	public List<ProductBackLogUserStory> findUnAssignedDeveloperUserStoryByProductId(int pid,String usertype);

}
