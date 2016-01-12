package com.scrum.portal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scrum.portal.dto.Employee;
import com.scrum.portal.model.EmployeeFormBean;
import com.scrum.portal.services.EmployeeServiceInterface;



@Controller
public class HREmployeeController 
{
	
	@Autowired
	private EmployeeServiceInterface employeeService;
	
	@RequestMapping(value="employeeCreate", method=RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") EmployeeFormBean employeeModel)
	{
		System.out.println("Hr controller");
		employeeService.createEmployee(employeeModel);
		//List<Employee> list = new ArrayList<Employee>();
		//return "redirect:listAllEmployee/"+list;
		return "redirect:listAllEmployee";
		
	}
	
	@RequestMapping(value="EmployeeCreate", method=RequestMethod.GET)
	public String hrDashboard(Model model){
		
		return "EmployeeCreate";
	}
	
	//view by employee ID
	@RequestMapping(value="viewEmployee", method=RequestMethod.POST) //if value getting jsp page form then post will work
	public String viewEmployee(@ModelAttribute("viewemployee") EmployeeFormBean viewEmployee)
	{
		System.out.println("View employe");
		employeeService.viewEmployee(viewEmployee);
		return "ViewEmployee";
				
	}
	
	@RequestMapping(value="ViewEmployeeHome", method=RequestMethod.GET)
	public String viewEmployeeHomePage()
	{
		return "ViewEmployeeHome";
	}
	
	//UpdateEmployee
	@RequestMapping(value="UpdateEmployeeHome", method=RequestMethod.GET) //method must be get else server doesn't know where to go 
	public String updateEmployeeHomePage()
	{
		return "UpdateEmployeeHome";
	}
	
	
	@RequestMapping(value="updateEmployeeViewPage", method=RequestMethod.POST) //if value getting jsp page form then post will work
	public String updateEmployeeViewDetails(@ModelAttribute("viewemployee") EmployeeFormBean viewEmployee)
	{
		System.out.println("update employe view page");
		employeeService.viewEmployee(viewEmployee);
		return "UpdateEmployee";
				
	}
	
	@RequestMapping(value="updateEmployee", method=RequestMethod.POST) //method must be get else server doesn't know where to go 
	public String updateEmployee(@ModelAttribute("employee") EmployeeFormBean employeeModel)
	{
		System.out.println("************** Update Employee");
		employeeService.updateEmployee(employeeModel);
		//return "/listAllEmployee";
		return "redirect:/listAllEmployee"; // / is for immediate next to parent domain 
	}

	
	@RequestMapping(value="DeleteEmployeeHome", method=RequestMethod.GET)
	public String deleteEmployeeHomePage()
	{
		return "DeleteEmployeeHome";
	}
	
	@RequestMapping(value="deleteEmployee", method=RequestMethod.POST) //if value getting jsp page form then post will work
	public String deleteEmployee(@ModelAttribute("deleteemployee") EmployeeFormBean deleteEmployee)
	{
		System.out.println("delete employe");
		employeeService.deleteEmployee(deleteEmployee);
		return "redirect:/listAllEmployee";
				
	}
	
	@RequestMapping(value="listAllEmployee", method=RequestMethod.GET)
	public String listAllEmployee(Model model) //you can use model attribute but one attibute only it will hold
	{
		List<Employee> employees = new ArrayList<Employee>();
		employees = employeeService.listAllEmployees(employees);
		System.out.println("l value "+employees.size());
		model.addAttribute("listAllemployee", employees);
		
		return "ListAllEmployee";
		
		//solution will add in model attribute the list  of employee the get tat iin UI
	}
	
	//direct delete
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET) //here must use get or server don't know where to go .. if value getting jsp page form then post will work
	public String deleteEmployee(@PathVariable int  id)
	{
		System.out.println("delete employe in UI");
		employeeService.deleteById(id);
		return "redirect:/listAllEmployee"; // / means parent 
				
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET) //here must use get or server don't know where to go if value getting jsp page form then post will work
	public String editEmployee(@PathVariable int  id, Model model)
	{
		System.out.println("edit employe in UI");
		Employee empOB = employeeService.viewById(id);
		model.addAttribute("viewemployee", empOB);
		return "UpdateEmployeeDetails";
				
	}
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET) //here must use get or server don't know where to go if value getting jsp page form then post will work
	public String viewEmployeeById(@PathVariable int  id, Model model)
	{
		System.out.println("view employe in UI");
		Employee empOB = employeeService.viewById(id);
		
		
		
		model.addAttribute("viewemployee", empOB);
		return "ViewEmployeeDeatail"; // view page by id
				
	}
	
	//this for url mapping 
	@RequestMapping(value="edit/updateEmployee", method=RequestMethod.POST) //method must be get else server doesn't know where to go 
	public String updateEmployeebyId(@ModelAttribute("employee") EmployeeFormBean employeeModel)
	{
		System.out.println("************** Update Employee");
		employeeService.updateEmployee(employeeModel);
		
		if(employeeModel.getRole()==8)
			return "redirect:/"; //for developer UI return
		
		return "redirect:/listAllEmployee";
	}

}
