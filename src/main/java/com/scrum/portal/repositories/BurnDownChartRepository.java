package com.scrum.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.UserStoryEffortLog;

@Repository
public interface BurnDownChartRepository extends CrudRepository<ProductBackLogUserStory, Integer>
{
	
	@Query("select u.userStory_Id from ProductBackLogUserStory u where u.sprintId = ?1")
	List<Integer> getProductBackLogObject(int sprintID);
	
	@Query("select u.estimateEffort_Dev from ProductBackLogUserStory u where u.sprintId in ?1")
	List<Integer> getTotalEstimateEffort(int sprintID);
	
	@Query("select u from UserStoryEffortLog u where u.userStory_Id in (select u.userStory_Id from ProductBackLogUserStory u where u.sprintId = ?1)")
	List<UserStoryEffortLog> getUserEffortLogData(int sprintID);
	
	@Query("select max(u.day) from UserStoryEffortLog u where u.userStory_Id in (select u.userStory_Id from ProductBackLogUserStory u where u.sprintId = ?1)")
	Integer getMaxDay(int sprintID);

}
