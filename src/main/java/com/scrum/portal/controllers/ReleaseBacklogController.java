package com.scrum.portal.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.ReleaseBackLog;
import com.scrum.portal.model.ReleaseFormBean;
import com.scrum.portal.model.SprintFormBean;
import com.scrum.portal.services.ReleaseBacklogService;
import com.scrum.portal.services.UserStoryService;



@Controller
@RequestMapping(value="/releasebacklog")
public class ReleaseBacklogController {
	
	@Autowired
	private ReleaseBacklogService releasebacklogservice;
	@Autowired
	private UserStoryService userstoryservice;
	
	@RequestMapping(value = "/add/{pid}", method = RequestMethod.GET)
	public String sprintForm(@PathVariable("pid")int pid,Model model) {
		
		model.addAttribute("productId", pid);
		model.addAttribute("actionTitle", "Add Release Backlog");
		model.addAttribute("actionText", "/releasebacklog/addreleasebacklog/"+pid);
		model.addAttribute("page", "releaseBacklog/AddReleaseBacklog");
		return "Container";
		
	}
	
	
	@RequestMapping(value="/addreleasebacklog/{pid}",method=RequestMethod.POST)
	public String addReleaseBacklog(@PathVariable("pid")int pid,@ModelAttribute("releaseFormbean") ReleaseFormBean release,Model model) throws IllegalAccessException, InvocationTargetException
	{
		
		if(releasebacklogservice.createReleaseBacklog(release)){
			//redirectAttributes.addFlashAttribute("flashSuccessMsg", "New Sprint Added Successfully"); 
			return "redirect:/releasebacklog/listreleases/"+pid;
		}
	
		return "redirect:/releasebacklog/add/"+pid;   
	}
	
	@RequestMapping(value="/listreleases/{pid}",method=RequestMethod.GET)
	public String listReleases(Model model,@PathVariable("pid")int pid)
	{
		
		List<ReleaseBackLog> releasebacklogs=releasebacklogservice.findReleaseByProductId(pid);

		List<ProductBackLogUserStory> userStories = userstoryservice.findUserStoryByProductId(pid);
		// For Release Add
		model.addAttribute("productId", pid);
		model.addAttribute("actionTitle", "Add Release Backlog");
		model.addAttribute("actionText", "/releasebacklog/addreleasebacklog/"+pid);
		//End
		
		model.addAttribute("pid", pid);
		model.addAttribute("userStories", userStories);
		model.addAttribute("releasebacklogs", releasebacklogs);
		model.addAttribute("page", "releaseBacklog/Releases");
		return "Container";
	}
	
	
	@RequestMapping(value="/edit/{pid}/{id}",method=RequestMethod.GET)
	public String editSprint(@PathVariable("pid")int pid,@PathVariable("id")int id,@ModelAttribute("sprint") SprintFormBean sprint,Model model) throws IllegalAccessException, InvocationTargetException
	{
		
		ReleaseBacklog release = releasebacklogservice.findReleaseBacklogById(id);
		model.addAttribute("actionText", "/releasebacklog/updatereleasebacklog/"+pid);
		model.addAttribute("productId", pid);
		model.addAttribute("id", id);
		model.addAttribute("release", release);
		model.addAttribute("page", "releaseBacklog/AddReleaseBacklog");
		model.addAttribute("actionTitle", "Edit Release Backlog");
		return "Container";    
		
	}
	
	
	@RequestMapping(value="/updatereleasebacklog/{pid}",method=RequestMethod.POST)
	public String updatesprint(@PathVariable("pid")int pid,@ModelAttribute("release") ReleaseFormBean releaseFormBean,Model model) throws IllegalAccessException, InvocationTargetException
	{

		
		if(releasebacklogservice.updateReleaseBacklog(releaseFormBean)){
			
			return "redirect:/releasebacklog/listreleases/"+pid;
		}
	
		model.addAttribute("page", "releaseBacklog/AddReleaseBacklog/"+pid);
	
		return "Container";
	}
	
	@RequestMapping(value="/delete/{pid}/{id}",method=RequestMethod.GET)
	public String deleteSprint(@PathVariable("pid") int pid,@PathVariable("id") int id) throws IllegalAccessException, InvocationTargetException
	{
		
		releasebacklogservice.delete(id);
			
		return "redirect:/releasebacklog/listreleases/"+pid;
		
	}
	
	
	
	 
	
}
