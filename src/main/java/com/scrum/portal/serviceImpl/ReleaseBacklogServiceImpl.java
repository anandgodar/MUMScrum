package com.scrum.portal.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.ReleaseBackLog;
import com.scrum.portal.model.ReleaseFormBean;
import com.scrum.portal.repositories.ReleaseBacklogRepository;
import com.scrum.portal.services.ReleaseBacklogService;


@Service
public class ReleaseBacklogServiceImpl implements ReleaseBacklogService
{

	@Autowired
	private ReleaseBacklogRepository releaseRespository; 
	

	@Override
	public boolean createReleaseBacklog(ReleaseFormBean release) throws IllegalAccessException, InvocationTargetException {
		
		//Sprint sprintOb = new Sprint();
		ReleaseBacklog releaseEntity = new ReleaseBacklog()  ;
		releaseEntity.setDescription(release.getDescription());
		releaseEntity.setId(release.getId());
		releaseEntity.setProductId(release.getProductId());
		releaseEntity.setName(release.getName());
		if(releaseRespository.save(releaseEntity) != null){
			return true;
		}
		
		return false;
	
	
		
	}


	@Override
	public List<ReleaseBacklog> findAll() {
		return releaseRespository.findAll();
	}


	@Override
	public ReleaseBacklog findReleaseBacklogById(int id) {
		return releaseRespository.findOne(id);
	}


	@Override
	public boolean updateReleaseBacklog(ReleaseFormBean release) {
		
		ReleaseBacklog releaseEntity = new ReleaseBacklog() ;
		releaseEntity.setDescription(release.getDescription());
		releaseEntity.setName(release.getName());
		releaseEntity.setId(release.getId());
		releaseEntity.setProductId(release.getProductId());
		if(releaseRespository.save(releaseEntity)!=null){
			return true;
		}
		return false;
	}


	@Override
	public void delete(int id) {
		releaseRespository.delete(id);
		
	}


	@Override
	public List<ReleaseBackLog> findReleaseByProductId(int pid) {
		return releaseRespository.findReleaseByProductId(pid);
	}

	
	

	
	


}
