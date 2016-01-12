package com.scrum.portal.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.scrum.portal.dto.Sprint;
import com.scrum.portal.model.SprintFormBean;




public interface SprintService 
{
	public boolean createSprint(SprintFormBean sprint) throws IllegalAccessException, InvocationTargetException;
	
	public List<Sprint> findAll();

	public Sprint findSprintById(int id);

	
	public boolean updateSprint(SprintFormBean sprint);

	public void delete(int id);

	List<Sprint> findSprintByreleaseid(int rid);

}

