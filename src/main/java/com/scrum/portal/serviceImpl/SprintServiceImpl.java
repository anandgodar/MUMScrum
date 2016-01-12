package com.scrum.portal.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.Sprint;
import com.scrum.portal.model.SprintFormBean;
import com.scrum.portal.repositories.SprintRepository;
import com.scrum.portal.services.SprintService;


@Service
public class SprintServiceImpl implements SprintService
{

	@Autowired
	private SprintRepository sprintRespository; 
	

	@Override
	public boolean createSprint(SprintFormBean sprint) throws IllegalAccessException, InvocationTargetException {
		
		//Sprint sprintOb = new Sprint();
		Sprint sprintEntity = new Sprint()  ;
		sprintEntity.setDescription(sprint.getDescription());
		sprintEntity.setName(sprint.getName());
		sprintEntity.setReleaseid(sprint.getReleaseid());
		if(sprintRespository.save(sprintEntity) != null){
			return true;
		}
		
		return false;
	
	
		
	}

	@Override
	public List<Sprint> findAll() {
		return sprintRespository.findAll();
	}

	@Override
	public Sprint findSprintById(int id) {
		return sprintRespository.findOne(id);
	}

	@Override
	public boolean updateSprint(SprintFormBean sprint) {
		
		Sprint sprintEntity = new Sprint() ;
		sprintEntity.setDescription(sprint.getDescription());
		sprintEntity.setName(sprint.getName());
		sprintEntity.setId(sprint.getId());
		sprintEntity.setReleaseid(sprint.getReleaseid());
		if(sprintRespository.save(sprintEntity)!=null){
			return true;
		}
		return false;
	}

	@Override
	public void delete(int id) {
		 sprintRespository.delete(id);
		
	}
	
	@Override
	public List<Sprint> findSprintByreleaseid(int rid) {
		return sprintRespository.findSprintByreleaseid(rid);
	}
	


}
