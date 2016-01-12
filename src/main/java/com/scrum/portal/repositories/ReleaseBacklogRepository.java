package com.scrum.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.ReleaseBackLog;


@Repository
public interface ReleaseBacklogRepository extends JpaRepository<ReleaseBackLog,Integer>{
	//@Query("SELECT P FROM RELEASEBACKLOG P WHERE P.PRODUCTID = :id")
	public List<ReleaseBackLog> findByProductId(@Param("pid") int pid);
	
}
