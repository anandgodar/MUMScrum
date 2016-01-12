package com.scrum.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaRepository<Employee, Integer>
{
	
	@Query("select u from Employee u where u.employeeID = ?1")
	Employee findByEmployeeId(int empId);
	
	
	/*@Query("Delete from Employee u where u.employeeID = ?1")
	void deleteByEmployeeId(int empId);*/
	

}
