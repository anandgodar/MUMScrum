package com.scrum.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.Employee;
import com.scrum.portal.dto.User;
import com.scrum.portal.model.EmployeeFormBean;
import com.scrum.portal.repositories.EmployeeRepository;
import com.scrum.portal.services.EmployeeServiceInterface;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void createEmployee(EmployeeFormBean employee) {
		System.out.println("service");

		// hibernate mapping one to one
		User userDto = new User();
		//userDto.setId(employee.getEmployeeID()); //newly added
		userDto.setUserName(employee.getUserName());
		userDto.setPassword(employee.getPassword());
		userDto.setRoleID(employee.getRole()); //setting role 

		Employee empDto = new Employee();
		empDto.setFirstName(employee.getFirstName());
		empDto.setLastName(employee.getLastName());
		empDto.setEmail(employee.getEmail());
		empDto.setEmployeeID(employee.getEmployeeID());
		empDto.setStreet(employee.getStreet());
		empDto.setState(employee.getState());
		empDto.setCity(employee.getCity());
		empDto.setCountry(employee.getCountry());
		empDto.setZip(employee.getZip());
		
		empDto.setUser(userDto);

		userDto.setEmployee(empDto);

		//List<EmployeeRole> empRoles = createRoles(employee);
		//empDto.setEmployeeRoles(empRoles); // mapping roles
		
		/*for (int i = 0; i < empRoles.size(); i++) 
		{
			empRoles.get(i).setEmployee(empDto);
		}*/
		

		employeeRepository.save(empDto);

	}

	/*public List<EmployeeRole> createRoles(EmployeeFormBean employee) {
		List<EmployeeRole> empRoles = new ArrayList<EmployeeRole>();

		System.out.println("Role " + employee.getRole());
		switch (employee.getRole()) {
		case 1:
			

			empRoles.add(new EmployeeRole(1));
			break;
		case 2:
			
			empRoles.add(new EmployeeRole(2));
			break;
		case 3:
			
			empRoles.add(new EmployeeRole(3));
			break;
		case 4:
			empRoles.add(new EmployeeRole(1));
			empRoles.add(new EmployeeRole(2));
			break;
		case 5:
			empRoles.add(new EmployeeRole(2));
			empRoles.add(new EmployeeRole(3));
			
			break;
		case 6:
			empRoles.add(new EmployeeRole(3));
			empRoles.add(new EmployeeRole(1));

			
			break;
		case 7:
			empRoles.add(new EmployeeRole(1));
			empRoles.add(new EmployeeRole(2));
			empRoles.add(new EmployeeRole(3));
			
			break;

		default:
			break;
		}
		return empRoles;

	}*/

	@Override
	public void viewEmployee(EmployeeFormBean viewEmployeeForm) 
	{
		
		System.out.println("form bean id "+viewEmployeeForm.getEmployeeID());
		
		Employee viewEmployeeOb = employeeRepository.findByEmployeeId(viewEmployeeForm.getEmployeeID()); //calling by query 
		
		System.out.println("inside view employee"+viewEmployeeOb.getEmployeeID()  );
		
		//setting dto to formbean
		viewEmployeeForm.setEmployeeID(viewEmployeeOb.getEmployeeID());
		viewEmployeeForm.setFirstName(viewEmployeeOb.getFirstName());
		viewEmployeeForm.setLastName(viewEmployeeOb.getLastName());
		viewEmployeeForm.setEmail(viewEmployeeOb.getEmail());
		viewEmployeeForm.setStreet(viewEmployeeOb.getStreet());
		viewEmployeeForm.setCity(viewEmployeeOb.getCity());
		viewEmployeeForm.setState(viewEmployeeOb.getState());
		viewEmployeeForm.setCountry(viewEmployeeOb.getCountry());
		viewEmployeeForm.setZip(viewEmployeeOb.getZip());
		viewEmployeeForm.setEmpId(viewEmployeeOb.getId()); //setting hidden field 
		
		System.out.println("user name"+viewEmployeeOb.getUser().getUserName());
		viewEmployeeForm.setUserName(viewEmployeeOb.getUser().getUserName());
		viewEmployeeForm.setPassword(viewEmployeeOb.getUser().getPassword());
		viewEmployeeForm.setRole(viewEmployeeOb.getUser().getRoleID());
		viewEmployeeForm.setUserId(viewEmployeeOb.getUser().getId()); //setting hidden field 
		
		
		
		
		
	}

	@Override
	public void updateEmployee(EmployeeFormBean employee) 
	{

		System.out.println("update service");

		// hibernate mapping one to one
		User userDto = new User();
		userDto.setId(employee.getUserId());  //primary key 
		userDto.setUserName(employee.getUserName());
		userDto.setPassword(employee.getPassword());
		userDto.setRoleID(employee.getRole()); //setting role 

		Employee empDto = new Employee();
		empDto.setId(employee.getEmpId()); //primary key
		empDto.setFirstName(employee.getFirstName());
		empDto.setLastName(employee.getLastName());
		empDto.setEmail(employee.getEmail());
		empDto.setEmployeeID(employee.getEmployeeID());
		empDto.setStreet(employee.getStreet());
		empDto.setState(employee.getState());
		empDto.setCity(employee.getCity());
		empDto.setCountry(employee.getCountry());
		empDto.setZip(employee.getZip());
		
		empDto.setUser(userDto);

		userDto.setEmployee(empDto);

		
		//List<EmployeeRole> empRoles = createRoles(employee);
		//empDto.setEmployeeRoles(empRoles); // mapping roles
		
		/*for (int i = 0; i < empRoles.size(); i++) 
		{
			empRoles.get(i).setEmployee(empDto);
		}*/
		

		employeeRepository.save(empDto);

		
		//createEmployee(employee);
		
		
	}

	@Override
	public void deleteEmployee(EmployeeFormBean employee) 
	{
		
		System.out.println("delete employee" +employee.getEmployeeID());
		Employee viewEmployeeOb = employeeRepository.findByEmployeeId(employee.getEmployeeID()); // check both tables are deleted 
		employeeRepository.delete(viewEmployeeOb.getId());

		
	}

	@Override
	public List<Employee> listAllEmployees(List<Employee> listAllEmployee)
	{
		
		System.out.println("list all employees ");
		listAllEmployee = employeeRepository.findAll();
		System.out.println("employee service ##############"+listAllEmployee.size());
		return listAllEmployee;
	}

	@Override
	public void deleteById(int id) 
	{
		employeeRepository.delete(id);
		
		
	}

	@Override
	public Employee viewById(int id) 
	{
		
System.out.println("form bean id "+id);
		
		Employee viewEmployeeOb = employeeRepository.findOne(id); //pass the primary key  
		return viewEmployeeOb;
		
	}

}
