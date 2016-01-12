package com.scrum.portal.services;

import java.util.List;

import com.scrum.portal.dto.Employee;
import com.scrum.portal.model.EmployeeFormBean;

public interface EmployeeServiceInterface 
{
	public void createEmployee(EmployeeFormBean employee);
	public void viewEmployee(EmployeeFormBean employee);
	public void updateEmployee(EmployeeFormBean employee);
	public void deleteEmployee(EmployeeFormBean employee);
	
	
	
	public List<Employee> listAllEmployees(List<Employee> listAllEmployee);
	public void deleteById(int id);
	public Employee viewById(int id);

}
