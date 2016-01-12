package com.scrum.portal.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.model.UserStoryFormBean;
import com.scrum.portal.repositories.UserStoryRepository;
import com.scrum.portal.services.UserStoryService;

@Service
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	UserStoryRepository userStoryRepository;

	@Override
	public List<ProductBackLogUserStory> findAll() {

		return userStoryRepository.findAll();
	}

	@Override
	public boolean createUserStory(UserStoryFormBean userStory)
			throws IllegalAccessException, InvocationTargetException {


		ProductBackLogUserStory userStoryEntity = new ProductBackLogUserStory();
		userStoryEntity.setUserStory_Desc(userStory.getDescription());
		userStoryEntity.setProductid(userStory.getProductid());
		
		/*userStoryEntity.setReleaseId(userStory.getReleaseId());
		userStoryEntity.setSprintId(userStory.getSprintId());*/

		if (userStoryRepository.save(userStoryEntity) != null) {

			System.out.println("ADDING RETURN TRUE");
			return true;
		}

		System.out.println("ADDING RETURN FALSE");
		return false;

	}

	@Override
	public ProductBackLogUserStory findUserStoryById(int id) {

		return userStoryRepository.findOne(id);
	}

	@Override
	public boolean updateUserStory(UserStoryFormBean userStory) {

		ProductBackLogUserStory userStoryEntity = new ProductBackLogUserStory();
		userStoryEntity.setUserStory_Desc(userStory.getDescription());
		userStoryEntity.setProductid(userStory.getProductid());
		userStoryEntity.setId(userStory.getId());

		if (userStoryRepository.save(userStoryEntity) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(int id) {

		userStoryRepository.delete(id);
	}
	
	
	
	
	@Override
	public List<ProductBackLogUserStory> findUserStoryByProductId(int pid) {
		return userStoryRepository.findProductBackLogUserStoryByproductid(pid);
	}
	
	
	
	
	@Override
	public List<ProductBackLogUserStory> findUnAssignedUserStoryByProductId(int pid) {
		return userStoryRepository.findByProductId(pid);
	}

	@Override
	public void updateReleaseId(int id, int pid, int rid) {
		
		userStoryRepository.updateReleaseId(rid,id,pid);
		
		
	}

	@Override
	public List<ProductBackLogUserStory> findUserStoryByreleaseId(int rid) {
		return userStoryRepository.findUserStoryByreleaseId(rid);
	}

	
	


	@Override
	public List<ProductBackLogUserStory> findUnAssignedUserStoryBySprintId(int pid) {
		return userStoryRepository.findUnAssignedUserStoryBySprintId(pid);
	}

	@Override
	public List<ProductBackLogUserStory> findUserStoryBySprintId(int sprintid) {
		return  userStoryRepository.findUserStoryBySprintId(sprintid);
	}

	@Override
	public void updateSprintId(int id, int sid, int pid) {
		userStoryRepository.updateSprintId(id,sid,pid);
		
	}

	@Override
	public void updateDeveloperAndTesterIdInUserStory(int uid, int did, int pid,String usertype) {
		if(usertype.equals("tester")){
			userStoryRepository.updateTesterIdInUserStory(uid, did, pid);
			System.out.println("Inside Tester"+usertype);
		}else{
			userStoryRepository.updateDeveloperAndTesterIdInUserStory(uid, did, pid);
			System.out.println("Inside " +usertype);
			
		}
		
		
	}

	@Override
	public List<ProductBackLogUserStory> findUserStoryByDeveloperId(int did,String usertype) {
		if(usertype.equals("developer")){
			return userStoryRepository.findUserStoryBydeveloperID(did);
		}else{
			return userStoryRepository.findUserStoryBytesterID(did);
		}
	}

	@Override
	public List<ProductBackLogUserStory> findUnAssignedDeveloperUserStoryByProductId(int pid,String usertype) {
		
		if(usertype.equals("developer")){
			return userStoryRepository.findUnAssignedDeveloperUserStoryByProductId(pid);
		}else{
			return userStoryRepository.findUnAssignedTesterUserStoryByProductId(pid);
		}
	}
	

}
