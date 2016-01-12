package com.scrum.portal.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.UserStoryEffortLog;
import com.scrum.portal.repositories.UpdateUserStoryEffortRepository;
import com.scrum.portal.serviceImpl.UpdateUserStoryEffortServiceImpl;
import com.scrum.portal.serviceImpl.UpdateUserStoryTesterEffortServiceImpl;
import com.scrum.portal.services.UpdateUserStoryEffortService;
import com.scrum.portal.services.UpdateUserStoryTesterEffortService;

@Controller

public class UpdateUserStoryTestEffortController 
{
	
	@Autowired
	private UpdateUserStoryTesterEffortService updateUserStoryService;
	@Autowired
	private UpdateUserStoryEffortRepository updateUserStoryEffortRepository;
	
	
	@RequestMapping(value="updateUserEffortTester/{index}", method=RequestMethod.GET)
	public String updateUserStoryEffortByTester(@PathVariable("index") int index ,Model model, HttpSession session)
	{
		System.out.println("updateUserStoryEffortByTester for 0");
		/*User user = (User) session.getAttribute("userInfo");
		System.out.println("user employee id "+user.getEmployee().getEmployeeID());
		int developer_Id = user.getEmployee().getEmployeeID(); //get id from session 
*/		
		//List<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryActualEffort(984664);
		List<ProductBackLogUserStory> originalList = new ArrayList<ProductBackLogUserStory>();
		
		System.out.println("index value from UI"+index);
		/*if(index == null)
			index =0;*/
		
		Page<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryTestActualEffort(984664,index);
		System.out.println("list size "+list.getSize());
		
		for (ProductBackLogUserStory productBackLogUserStory : list) 
		{
			originalList.add(productBackLogUserStory);
			
		}
		
		System.out.println("originalList size"+originalList.size());
		model.addAttribute("listOfUserStories", originalList);
		
		model.addAttribute("totalNumberOfRecord", UpdateUserStoryTesterEffortServiceImpl.totalNumberOfRecordsForTester/2); //setting total nuumber of records 
		
		return "UpdateActualEffortTester";
	}
	
	@RequestMapping(value="updateEstimateEffortTester/{index}", method=RequestMethod.GET)
	public String updateEstimateEffortByTester(@PathVariable("index") int index ,Model model, HttpSession session)
	{
		System.out.println("updateUserStoryEffortByTester for 0");
		/*User user = (User) session.getAttribute("userInfo");
		System.out.println("user employee id "+user.getEmployee().getEmployeeID());
		int developer_Id = user.getEmployee().getEmployeeID(); //get id from session 
*/		
		//List<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryActualEffort(984664);
		List<ProductBackLogUserStory> originalList = new ArrayList<ProductBackLogUserStory>();
		
		System.out.println("index value from UI"+index);
		/*if(index == null)
			index =0;*/
		
		Page<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryTestActualEffort(984664,index);
		System.out.println("list size "+list.getSize());
		
		for (ProductBackLogUserStory productBackLogUserStory : list) 
		{
			originalList.add(productBackLogUserStory);
			
		}
		
		System.out.println("originalList size"+originalList.size());
		model.addAttribute("listOfUserStories", originalList);
		
		model.addAttribute("totalNumberOfRecord", UpdateUserStoryTesterEffortServiceImpl.totalNumberOfRecordsForTester/2); //setting total nuumber of records 
		
		return "UpdateEstimateEffortTester";
	}
	
	
	// same controler request for developer too
	@RequestMapping(value="updateUserStoryTester/{id}", method=RequestMethod.GET)
	public String ViewUserStoryPage(@PathVariable("id") int UsId, Model model)
	{
		System.out.println("inside tester update user story"+ UsId);
		
		ProductBackLogUserStory ob = updateUserStoryService.findUserStoryById(UsId);
		System.out.println("ob.getUserStory_Id()"+ob.getUserStory_Id());
		model.addAttribute("productBackLogUserStory", ob);
		
		return "UpdateEffortTester";
		
	}
	
	@RequestMapping(value="estimateTestEffortUserStory/{id}", method=RequestMethod.GET)
	public String EstimateTestEffortUserStory(@PathVariable("id") int UsId, Model model)
	{
		System.out.println("inside tester update user story"+ UsId);
		
		ProductBackLogUserStory ob = updateUserStoryService.findUserStoryById(UsId);
		System.out.println("ob.getUserStory_Id()"+ob.getUserStory_Id());
		model.addAttribute("productBackLogUserStory", ob);
		
		return "EstimateTestEffort";
		
	}
	
	
	@RequestMapping(value="updateTestEffort", method=RequestMethod.GET) //maintaing session must have get 
	public String updateActualEffortUserStory(@ModelAttribute("userStoryEffortLog") UserStoryEffortLog userStoryEffortLog)
	{
		
		System.out.println("method tester inside update effort log");
		updateUserStoryService.createUserStoryEffortLog(userStoryEffortLog);
		
		updateUserStoryService.updateTestUserStoryEffort(userStoryEffortLog);
		
		return "redirect:/"; //redirecting home page 
		
	}
	
	@RequestMapping(value="updateTestEstimateEffort", method=RequestMethod.GET) //maintaing session must have get 
	public String updateestimateEffortUserStory(@ModelAttribute("productBackLogUserStory") ProductBackLogUserStory productBackLogUserStory)
	{
		
		System.out.println("method tester inside Estimate effort log");
		
		int estimateEffort = productBackLogUserStory.getEstimateEffort_Test();
		int userStoryId = productBackLogUserStory.getUserStory_Id();
		
		
		updateUserStoryEffortRepository.updateEstimateEffortTest(estimateEffort, userStoryId);
		
		return "redirect:/"; //redirecting home page 
		
	}
	
	
	

}
