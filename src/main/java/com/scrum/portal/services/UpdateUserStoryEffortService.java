package com.scrum.portal.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.UserStoryEffortLog;

public interface UpdateUserStoryEffortService 
{
	
	//public List<ProductBackLogUserStory> updateUserStoryActualEffort(int developer_Id);
	public Page<ProductBackLogUserStory> updateUserStoryActualEffort(int developer_Id, int index);
	
	public ProductBackLogUserStory findUserStoryById(int id);
	public void createUserStoryEffortLog(UserStoryEffortLog userStoryEffortLog);
	
	public void updateDevelopmentUserStoryEffort(UserStoryEffortLog userStoryEffortLog); //remaining effort in main table

}
