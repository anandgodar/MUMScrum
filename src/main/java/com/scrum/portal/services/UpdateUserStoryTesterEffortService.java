package com.scrum.portal.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.UserStoryEffortLog;

public interface UpdateUserStoryTesterEffortService 
{
	
	//public List<ProductBackLogUserStory> updateUserStoryActualEffort(int Tester_ID);
	public Page<ProductBackLogUserStory> updateUserStoryTestActualEffort(int Tester_ID, int index);
	
	public ProductBackLogUserStory findUserStoryById(int id);
	public void createUserStoryEffortLog(UserStoryEffortLog userStoryEffortLog);
	
	public void updateTestUserStoryEffort(UserStoryEffortLog userStoryEffortLog); //remaining effort in main table

}
