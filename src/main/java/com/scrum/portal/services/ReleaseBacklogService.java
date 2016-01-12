package com.scrum.portal.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.scrum.portal.dto.ReleaseBacklog;
import com.scrum.portal.dto.Sprint;
import com.scrum.portal.model.ReleaseFormBean;
import com.scrum.portal.model.SprintFormBean;




public interface ReleaseBacklogService 
{
	public boolean createReleaseBacklog(ReleaseFormBean sprint) throws IllegalAccessException, InvocationTargetException;
	
	public List<ReleaseBacklog> findAll();

	public ReleaseBacklog findReleaseBacklogById(int id);

	
	public boolean updateReleaseBacklog(ReleaseFormBean release);

	public void delete(int id);
	
	public List<ReleaseBacklog> findReleaseByProductId(int pid);

}

