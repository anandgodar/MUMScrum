package com.scrum.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.Sprint;


@Repository
public interface SprintRepository extends JpaRepository<Sprint,Integer>{
	public List<Sprint> findSprintByreleaseid(@Param("releaseid") int rid);
}
