package com.scrum.portal.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.ProductBackLogUserStory;

@Repository
public interface UpdateUserStoryEffortRepository extends org.springframework.data.repository.Repository<ProductBackLogUserStory, Integer>, CrudRepository<ProductBackLogUserStory, Integer>
{
	
	/*@Query("select u from ProductBackLogUserStory u where u.developerID = ?1")
	List<ProductBackLogUserStory> findByDeveloperId(int empName);*/
	
	
	// For developer
	Page<ProductBackLogUserStory> findBydeveloperID(int developer_ID, Pageable pageable); //method name should column we specified
	
	@Query("select count(*) from ProductBackLogUserStory u where u.developerID = ?1")
	Long findByDeveloperIdRecordCount(int developer_ID);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set estimateEffort_Dev=?1 where userStory_Id = ?2")
	Integer updateEstimateEffortDev(Integer estimateEffort, int userStory_Id);
	
	/**
	 * 
	 * findbytesterID must be in this form and must match with entity else throw error
	 * @param tester_ID - will be any name
	 * @param pageable
	 * @return
	 */
	//for tester
	Page<ProductBackLogUserStory> findBytesterID(int tester_ID, Pageable pageable); //method name should column we specified 
	
	@Query("select count(*) from ProductBackLogUserStory u where u.testerID = ?1")
	Long findByTesterIdRecordCount(int testerID);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set estimateEffort_Test=?1 where userStory_Id = ?2")
	Integer updateEstimateEffortTest(Integer estimateEffort, int userStory_Id);
	

}
