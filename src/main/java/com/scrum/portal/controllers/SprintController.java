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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scrum.portal.dto.ReleaseBacklog;
import com.scrum.portal.dto.Sprint;
import com.scrum.portal.model.SprintFormBean;
import com.scrum.portal.services.ReleaseBacklogService;
import com.scrum.portal.services.SprintService;

@Controller
@RequestMapping(value="/sprint")
public class SprintController {
	
	@Autowired
	private SprintService sprintservice;

	@Autowired
	private ReleaseBacklogService releasebacklogservice;
	
	
	@RequestMapping(value = "/add/{rid}", method = RequestMethod.GET)
	public String sprintForm(Model model,@PathVariable("rid")int rid) {
		
		ReleaseBacklog release = releasebacklogservice.findReleaseBacklogById(rid);
		List<ReleaseBacklog> releasebacklogs=releasebacklogservice.findReleaseByProductId(release.getProductId());
		model.addAttribute("releasebacklogs", releasebacklogs);
		
		model.addAttribute("rid", rid);
		model.addAttribute("actionTitle", "Add Sprint");
		model.addAttribute("actionText", "/sprint/addsprint/"+rid);
		model.addAttribute("page", "sprint/AddSprint");
		return "Container";
		
	}
	
	
	@RequestMapping(value="/addsprint/{rid}",method=RequestMethod.POST)
	public String addSprint(@PathVariable("rid")int rid,@ModelAttribute("sprint") SprintFormBean sprint,Model model,RedirectAttributes redirectAttributes) throws IllegalAccessException, InvocationTargetException
	{
		
		if(sprintservice.createSprint(sprint)){
			//redirectAttributes.addFlashAttribute("flashSuccessMsg", "New Sprint Added Successfully"); 
			return "redirect:/sprint/listsprints/"+rid;
		}
	
		return "redirect:/sprint/add/"+rid;
	}
	
	@RequestMapping(value="/listsprints/{rid}",method=RequestMethod.GET)
	public String listSprint(Model model,@PathVariable("rid")int rid)
	{
		
		model.addAttribute("rid", rid);
		model.addAttribute("actionTitle", "Add Sprint");
		model.addAttribute("actionText", "/sprint/addsprint/"+rid);
		
		List<Sprint> sprints=sprintservice.findSprintByreleaseid(rid);
		model.addAttribute("sprints", sprints);
		model.addAttribute("page", "sprint/Sprints");
		return "Container";
	}
	
	
	@RequestMapping(value="/edit/{rid}/{id}",method=RequestMethod.GET)
	public String editSprint(@PathVariable("rid")int rid,@PathVariable("id")int Id,@ModelAttribute("sprint") SprintFormBean sprint,Model model) throws IllegalAccessException, InvocationTargetException
	{
		
		Sprint mySprint = sprintservice.findSprintById(Id);
		model.addAttribute("rid", rid);
		model.addAttribute("actionText", "/sprint/updateSprint/"+rid);
		model.addAttribute("sprint", mySprint);
		model.addAttribute("page", "sprint/AddSprint");
		model.addAttribute("actionTitle", "Edit Sprint");
		return "Container";    
		
	}
	
	@RequestMapping(value="/updateSprint/{rid}",method=RequestMethod.POST)
	public String updatesprint(@PathVariable("rid")int rid,@ModelAttribute("sprint") SprintFormBean sprint,Model model) throws IllegalAccessException, InvocationTargetException
	{

		
		if(sprintservice.updateSprint(sprint)){
			
			return "redirect:/sprint/listsprints/"+rid;
		}
	
		model.addAttribute("page", "sprint/AddSprint/"+rid);
	
		return "Container";
	}
	
	@RequestMapping(value="/delete/{rid }/{id}",method=RequestMethod.GET)
	public String deleteSprint(@PathVariable("rid")int rid,@PathVariable("id") int Id) throws IllegalAccessException, InvocationTargetException
	{
		
		sprintservice.delete(Id);
			
		return "redirect:/sprint/listsprints/"+rid;
		
	}
	
	
	 
	
}
