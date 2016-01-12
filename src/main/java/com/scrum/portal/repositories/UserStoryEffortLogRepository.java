package com.scrum.portal.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.scrum.portal.dto.Employee;
import com.scrum.portal.dto.UserStoryEffortLog;

public interface UserStoryEffortLogRepository extends CrudRepository<UserStoryEffortLog, Integer>
{
	
	//For Developer
	@Query("select u.actualEffort_Dev from UserStoryEffortLog u where u.userStory_Id = ?1")
	List<Integer> findByUserId(int userStory_Id);
	
	@Query("select u.estimateEffort_Dev from ProductBackLogUserStory u where u.userStory_Id = ?1")
	Integer findEstimationEffortDev(int userStory_Id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set actualEffort_Dev=?1 where userStory_Id = ?2")
	Integer updateActualEffortDev(Integer actualEffort, int userStory_Id);
	
	
	/*@Query("update ProductBackLogUserStory u set u.actualEffort_Dev =:actualDEVEffort where u.userStory_Id =:id")
	void updateActualEffortDev(@Param("id") int userStory_Id, @Param("actualDEVEffort") int actualEffort_Dev);*/
	
	
	/**
	 * For Tester
	 */
	@Query("select u.actualEffort_Test from UserStoryEffortLog u where u.userStory_Id = ?1")
	List<Integer> findTestingLogByUserId(int userStory_Id);
	
	@Query("select u.estimateEffort_Test from ProductBackLogUserStory u where u.userStory_Id = ?1")
	Integer findEstimationEffortTest(int userStory_Id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set actualEffort_Test=?1 where userStory_Id = ?2")
	Integer updateActualEffortTest(Integer actualEffort, int userStory_Id);
	
	

}
