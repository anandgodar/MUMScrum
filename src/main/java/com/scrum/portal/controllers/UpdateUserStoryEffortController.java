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
import com.scrum.portal.services.UpdateUserStoryEffortService;

@Controller

public class UpdateUserStoryEffortController 
{
	
	@Autowired
	private UpdateUserStoryEffortService updateUserStoryService;
	@Autowired
	private UpdateUserStoryEffortRepository updateUserStoryEffortRepository;
	
	
	
	@RequestMapping(value="updateUserEffortDeveloper/{index}", method=RequestMethod.GET)
	public String updateUserStoryEffortByDeveloper(@PathVariable("index") int index ,Model model, HttpSession session)
	{
		System.out.println("updateUserStoryEffortByDeveloper for 0");
		/*User user = (User) session.getAttribute("userInfo");
		System.out.println("user employee id "+user.getEmployee().getEmployeeID());
		int developer_Id = user.getEmployee().getEmployeeID(); //get id from session 
*/		
		//List<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryActualEffort(984664);
		List<ProductBackLogUserStory> originalList = new ArrayList<ProductBackLogUserStory>();
		
		System.out.println("index value from UI"+index);
		/*if(index == null)
			index =0;*/
		
		Page<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryActualEffort(984664,index);
		System.out.println("list size "+list.getSize());
		
		for (ProductBackLogUserStory productBackLogUserStory : list) 
		{
			originalList.add(productBackLogUserStory);
			
		}
		
		System.out.println("originalList size"+originalList.size());
		model.addAttribute("listOfUserStories", originalList);
		
		model.addAttribute("totalNumberOfRecord", UpdateUserStoryEffortServiceImpl.totalNumberOfRecord/2); //setting total nuumber of records 
		
		return "UpdateActualEffortDevleoper";
	}
	
	@RequestMapping(value="updateEstimateEffortDeveloper/{index}", method=RequestMethod.GET)
	public String updateEstimateEffortByDeveloper(@PathVariable("index") int index ,Model model, HttpSession session)
	{
		System.out.println("updateUserStoryEstimateEffortByDeveloper for 0");
		/*User user = (User) session.getAttribute("userInfo");
		System.out.println("user employee id "+user.getEmployee().getEmployeeID());
		int developer_Id = user.getEmployee().getEmployeeID(); //get id from session 
*/		
		//List<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryActualEffort(984664);
		List<ProductBackLogUserStory> originalList = new ArrayList<ProductBackLogUserStory>();
		
		System.out.println("index value from UI"+index);
		/*if(index == null)
			index =0;*/
		
		Page<ProductBackLogUserStory> list = updateUserStoryService.updateUserStoryActualEffort(984664,index);
		System.out.println("list size "+list.getSize());
		
		for (ProductBackLogUserStory productBackLogUserStory : list) 
		{
			originalList.add(productBackLogUserStory);
			
		}
		
		System.out.println("originalList size"+originalList.size());
		model.addAttribute("listOfUserStories", originalList);
		
		model.addAttribute("totalNumberOfRecord", UpdateUserStoryEffortServiceImpl.totalNumberOfRecord/2); //setting total nuumber of records 
		
		return "UpdateEstimateEffortDevleoper";
	}
	
	
	@RequestMapping(value="updateUserStory/{id}", method=RequestMethod.GET)
	public String ViewUserStoryPage(@PathVariable("id") int UsId, Model model)
	{
		System.out.println("inside update user story"+ UsId);
		ProductBackLogUserStory ob = updateUserStoryService.findUserStoryById(UsId);
		System.out.println("ob.getUserStory_Id()"+ob.getUserStory_Id());
		model.addAttribute("productBackLogUserStory", ob);
		
		
		
		return "UpdateEffort";
		
	}
	
	@RequestMapping(value="estimateEffortUserStory/{id}", method=RequestMethod.GET)
	public String EstimateUserStoryPage(@PathVariable("id") int UsId, Model model)
	{
		System.out.println("inside update user story"+ UsId);
		ProductBackLogUserStory ob = updateUserStoryService.findUserStoryById(UsId);
		System.out.println("ob.getUserStory_Id()"+ob.getUserStory_Id());
		model.addAttribute("productBackLogUserStory", ob);
		
		
		
		return "EstimateDevEffort";
		
	}
	
	
	@RequestMapping(value="updateEffort", method=RequestMethod.GET) //maintaing session must have get 
	public String updateActualEffortUserStory(@ModelAttribute("userStoryEffortLog") UserStoryEffortLog userStoryEffortLog)
	{
		
		System.out.println("method inside update effort log");
		updateUserStoryService.createUserStoryEffortLog(userStoryEffortLog);
		
		updateUserStoryService.updateDevelopmentUserStoryEffort(userStoryEffortLog);
		
		
		return "redirect:/"; //redirecting home page 
		
	}
	
	@RequestMapping(value="estimateEffort", method=RequestMethod.GET) //maintaing session must have get 
	public String updateEstimateEffortUserStory(@ModelAttribute("productBackLogUserStory") ProductBackLogUserStory productBackLogUserStory)
	{
		
		System.out.println("method inside Estimate effort");
		
		int estimateEffort = productBackLogUserStory.getEstimateEffort_Dev();
		int userStoryId = productBackLogUserStory.getUserStory_Id();
		//change
		updateUserStoryEffortRepository.updateEstimateEffortDev(estimateEffort, userStoryId);
		
		
		return "redirect:/"; //redirecting home page 
		
	}
	
	

}
