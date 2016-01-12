package com.scrum.portal.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.ProductBackLogUserStory;

@Repository
public interface UserStoryRepository extends JpaRepository<ProductBackLogUserStory, Integer>{
	
	public List<ProductBackLogUserStory> findProductBackLogUserStoryByproductid(@Param("pid") int pid);

	@Query("select u from ProductBackLogUserStory u where u.productid = ?1 and u.releaseId=0") //
	public List<ProductBackLogUserStory> findByProductId(int productId);
	
/*	@Query("select u from ProductBackLogUserStory u where u.productId = ?1 and and u.releaseId is null") //
	public List<ProductBackLogUserStory> findUnAssignedUserStory(int productId);*/
	
	@Query("select u from ProductBackLogUserStory u where u.releaseId = ?1")
	public List<ProductBackLogUserStory> findUserStoryByreleaseId(int releaseId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set releaseId=?1 where id = ?2 and productId=?3")
	Integer updateReleaseId(int releaseId, int id ,int productId);
	

	
	@Query("select u from ProductBackLogUserStory u where u.productid = ?1 and u.sprintId=0")
	public List<ProductBackLogUserStory> findByUnAssignedByReleaseId( int productId);
	
	@Query("select u from ProductBackLogUserStory u where u.productid = ?1 and u.sprintId=0")
	public List<ProductBackLogUserStory> findUnAssignedUserStoryBySprintId( int pid );
	
	@Query("select u from ProductBackLogUserStory u where u.sprintId = ?1")
	public List<ProductBackLogUserStory> findUserStoryBySprintId(int sprintId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set sprintId=?2 where id = ?1 and productId=?3")
	Integer updateSprintId( int id ,int sprintId,int productId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set developerID=?2 where id = ?1 and productId=?3")
	public void updateDeveloperAndTesterIdInUserStory(int uid, int did, int pid);

	
	@Query("select u from ProductBackLogUserStory u where u.developerID = ?1")
	public List<ProductBackLogUserStory> findUserStoryBydeveloperID(int did);
	
	@Query("select u from ProductBackLogUserStory u where u.productid = ?1 and u.developerID=0")
	public List<ProductBackLogUserStory> findUnAssignedDeveloperUserStoryByProductId(int pid);
	
	//For Tester 
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ProductBackLogUserStory set testerID=?2 where id = ?1 and productId=?3")
	public void updateTesterIdInUserStory(int uid, int did, int pid);
	
	@Query("select u from ProductBackLogUserStory u where u.testerID = ?1")
	public List<ProductBackLogUserStory> findUserStoryBytesterID(int did);
	
	@Query("select u from ProductBackLogUserStory u where u.productid = ?1 and u.testerID=0")
	public List<ProductBackLogUserStory> findUnAssignedTesterUserStoryByProductId(int pid);
	//End of Tester
	
}
