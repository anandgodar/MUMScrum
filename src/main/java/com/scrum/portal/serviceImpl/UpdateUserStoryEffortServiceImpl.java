package com.scrum.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.UserStoryEffortLog;
import com.scrum.portal.repositories.UpdateUserStoryEffortRepository;
import com.scrum.portal.repositories.UserStoryEffortLogRepository;
import com.scrum.portal.services.UpdateUserStoryEffortService;

@Service
public class UpdateUserStoryEffortServiceImpl implements UpdateUserStoryEffortService
{
	
	static public Long totalNumberOfRecord; 

	@Autowired
	private UpdateUserStoryEffortRepository updateUSEffortRepository;
	@Autowired
	private UserStoryEffortLogRepository userStoryEffortLogRepository;
	
	@Override
	public Page<ProductBackLogUserStory> updateUserStoryActualEffort(int developer_Id, int index) 
	{
	
		
		System.out.println("page index "+index);
		Pageable pagesize = new PageRequest(index, 2);  //page start 0 
		
		//List<ProductBackLogUserStory> list = updateUSEffortRepository.findByDeveloperId(developer_Id);
		//List<ProductBackLogUserStory> list = (List<ProductBackLogUserStory>) updateUSEffortRepository.findAll();
		
		Page<ProductBackLogUserStory> list =  updateUSEffortRepository.findBydeveloperID(developer_Id, pagesize);
		
		totalNumberOfRecord = updateUSEffortRepository.findByDeveloperIdRecordCount(developer_Id);
		System.out.println("totalNumberOfRecord "+totalNumberOfRecord);
		
		
		for (ProductBackLogUserStory productBackLogUserStory : list) {
			
			System.out.println("productBackLogUserStory.getUserStory_Id()"+productBackLogUserStory.getUserStory_Id());
			System.out.println("productBackLogUserStory.getUserStory_Id()"+productBackLogUserStory.getUserStory_Desc());
		}
		return list;
	}

	@Override
	public ProductBackLogUserStory findUserStoryById(int id) {
		
		return updateUSEffortRepository.findOne(id);
	}

	@Override
	public void createUserStoryEffortLog(UserStoryEffortLog userStoryEffortLog) 
	{
		
		userStoryEffortLogRepository.save(userStoryEffortLog);
	}

	@Override
	public void updateDevelopmentUserStoryEffort(UserStoryEffortLog userStoryEffortLog) 
	{
		int userStoryId = userStoryEffortLog.getUserStory_Id();
		List<Integer> list = userStoryEffortLogRepository.findByUserId(userStoryId);
		Integer exitingEffort = 0;
		System.out.println("list size from log"+list.size());
		for (Integer listValue : list) 
		{
			exitingEffort += listValue;
			
		}
		System.out.println("exitingEffort "+exitingEffort);
		//exitingEffort += userStoryEffortLog.getActualEffort_Dev();
		System.out.println("added value "+exitingEffort);
		Integer estimationEffortFromDB = userStoryEffortLogRepository.findEstimationEffortDev(userStoryId);
		System.out.println("estimationEffortFromDB "+estimationEffortFromDB);
		
		Integer actualEffortDev = estimationEffortFromDB - exitingEffort;
		System.out.println("actualEffortDev "+actualEffortDev);
		
		
		userStoryEffortLogRepository.updateActualEffortDev(actualEffortDev,userStoryId);
		
		System.out.println("Complete");
		
		
		
		
	}

	
	

}
