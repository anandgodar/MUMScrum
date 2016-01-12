package com.scrum.portal.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.ReleaseBacklog;
import com.scrum.portal.dto.User;
import com.scrum.portal.model.UserStoryFormBean;
import com.scrum.portal.services.ReleaseBacklogService;
import com.scrum.portal.services.UserService;
import com.scrum.portal.services.UserStoryService;

@Controller
@RequestMapping(value = "/userstory")
public class UserStoryController {

	@Autowired
	UserStoryService userStoryService;
	
	@RequestMapping(value = "/listuserstories/{ptype}/{pid}", method = RequestMethod.GET)
	public String listUserStories(Model model,@PathVariable("pid") int pid, @PathVariable("ptype") String ptype) {
		
		if (ptype == "prouduct") {
			model.addAttribute("productid", pid);
		} else if (ptype == "sprint") {
			model.addAttribute("sprintid", pid);
		} else if (ptype == "release") {
			model.addAttribute("releaseid", pid);
		} else {
			model.addAttribute("productid", pid);

		}
		
		model.addAttribute("actionTitle", "Add UserStory");
		model.addAttribute("actionText", "/userstory/adduserstory/" + ptype + "/" + pid);
		model.addAttribute("page", "userStory/AddUserStory");
		
		List<ProductBackLogUserStory> userStories = userStoryService.findUserStoryByProductId(pid);
		model.addAttribute("userStories", userStories);
		model.addAttribute("page", "userStory/UserStories");
		return "Container";
	}
	
	
	
	/* Single User Story Add */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String sprintForm(Model model) {

		model.addAttribute("actionTitle", "Add UserStory");
		model.addAttribute("actionText", "/userstory/adduserstory");
		model.addAttribute("page", "userStory/AddUserStory");
		return "Container";
	}

	/*User Story Add for Product, Release and Sprint*/

	@RequestMapping(value = "/add/{ptype}/{pid}", method = RequestMethod.GET)
	public String sprintForm(Model model, @PathVariable("pid") int pid, @PathVariable("ptype") String ptype) {

		if (ptype == "prouduct") {
			model.addAttribute("productid", pid);
		} else if (ptype == "sprint") {
			model.addAttribute("sprintid", pid);
		} else if (ptype == "release") {
			model.addAttribute("releaseid", pid);
		} else {
			model.addAttribute("productid", pid);

		}

		model.addAttribute("actionTitle", "Add User Story");
		model.addAttribute("actionText", "/userstory/adduserstory/" + ptype + "/" + pid);
		model.addAttribute("page", "userStory/AddUserStory");
		return "Container";
	}
	
	

	@RequestMapping(value = "/adduserstory/{ptype}/{pid}", method = RequestMethod.POST)
	public String addSprint(@ModelAttribute("userStory") UserStoryFormBean userStory, Model model,
			RedirectAttributes redirectAttributes, @PathVariable("pid") int pid, @PathVariable("ptype") String ptype) throws IllegalAccessException, InvocationTargetException {

		if (ptype == "prouduct") {
			model.addAttribute("productid", pid);
		} else if (ptype == "sprint") {
			model.addAttribute("sprintid", pid);
		} else if (ptype == "release") {
			model.addAttribute("releaseid", pid);
		} else {
			model.addAttribute("productid", pid);

		}
		
		if (userStoryService.createUserStory(userStory)) {

			return "redirect:/userstory/listuserstories/"+ ptype + "/" + pid;
		}

		return "redirect:/userstory/add/"+ ptype + "/" + pid;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSprint(@PathVariable("id") int id, @ModelAttribute("userStory") UserStoryFormBean userStory,
			Model model) throws IllegalAccessException, InvocationTargetException {

		model.addAttribute("id",id);

		ProductBackLogUserStory myUserStory = userStoryService.findUserStoryById(id);
		model.addAttribute("actionText", "/userstory/update");
		model.addAttribute("userStory", myUserStory);
		model.addAttribute("page", "AddUserStory");
		model.addAttribute("actionTitle", "Edit UserStory");
		return "Container";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatesprint(@ModelAttribute("userStory") UserStoryFormBean userStory, Model model)
			throws IllegalAccessException, InvocationTargetException {

		if (userStoryService.updateUserStory(userStory)) {

			return "redirect:/userstory/listuserstories";
		}

		model.addAttribute("page", "Add UserStory");

		return "Container";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSprint(@PathVariable("id") int id) throws IllegalAccessException, InvocationTargetException {

		userStoryService.delete(id);

		return "redirect:/userstory/listuserstories";

	}
	
	@RequestMapping(value="/removeuserstoryfromproduct/{ptype}/{pid}/{uid}", method = RequestMethod.GET)
	public String removeUserStoryFromProduct(Model model, @PathVariable("pid") int pid, @PathVariable("uid") int uid, @PathVariable("ptype") String ptype) throws IllegalAccessException, InvocationTargetException{
		
		userStoryService.delete(uid);
		return "redirect:/userstory/listuserstories/"+ptype+"/"+pid;
	}
	
	
	@RequestMapping(value = "/assignuserstoriestorelease/{ptype}/{pid}/{rid}", method = RequestMethod.GET)
	public String assignUserStoriesToRelease(Model model,@PathVariable("pid") int pid,@PathVariable("rid") int rid, @PathVariable("ptype") String ptype) {
		
		List<ProductBackLogUserStory> userStories = userStoryService.findUserStoryByreleaseId(rid);
		List<ProductBackLogUserStory> unAssignedUserStories = userStoryService.findUnAssignedUserStoryByProductId(pid);
		model.addAttribute("unAssignedUserStories", unAssignedUserStories);
		model.addAttribute("userStories", userStories);
		model.addAttribute("rid", rid);
		System.out.println(userStories);
	
		model.addAttribute("page", "userStory/AssignUserStoryToRelease");
		return "Container";
	}
	
	@RequestMapping(value="/updatereleaseid/{pid}/{rid}/{id}", method = RequestMethod.GET)
	public String updatereleaseId(Model model, @PathVariable("pid") int pid, @PathVariable("id") int id, @PathVariable("rid") int rid) throws IllegalAccessException, InvocationTargetException{
		
		userStoryService.updateReleaseId(id,pid,rid);
		return "redirect:/userstory/assignuserstoriestorelease/release/"+pid+"/"+rid;
	}
	
	
	
	@Autowired
	private ReleaseBacklogService releasebacklogservice;
	
	@RequestMapping(value = "/assignuserstoriestosprint/{ptype}/{rid}/{sprintid}", method = RequestMethod.GET)
	public String assignUserStoriesToSprint(Model model,@PathVariable("rid") int rid,@PathVariable("sprintid") int sprintid, @PathVariable("ptype") String ptype) {
		
		
		ReleaseBacklog release = releasebacklogservice.findReleaseBacklogById(rid);
		List<ProductBackLogUserStory> userStories = userStoryService.findUserStoryBySprintId(sprintid);
		List<ProductBackLogUserStory> unAssignedUserStories = userStoryService.findUnAssignedUserStoryBySprintId(release.getProductId());
		model.addAttribute("unAssignedUserStories", unAssignedUserStories);
		model.addAttribute("userStories", userStories);
		model.addAttribute("sid", sprintid);
		model.addAttribute("rid", rid);
		 
	
		model.addAttribute("page", "userStory/AssignUserStoryToSprint");
		return "Container";
	}
	
	@RequestMapping(value="/updatesprintid/{pid}/{sid}/{id}/{rid}", method = RequestMethod.GET)
	public String updateSprintId(Model model,@PathVariable("rid") int rid, @PathVariable("pid") int pid, @PathVariable("id") int id, @PathVariable("sid") int sid) throws IllegalAccessException, InvocationTargetException{
		
		userStoryService.updateSprintId(id,sid,pid);
	
		return "redirect:/userstory/assignuserstoriestosprint/sprint/"+rid+"/"+sid;
	}
	
	
	/*Assign User story to Developer 
	*/
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/assignuserstorytouser/{usertype}/{pid}", method = RequestMethod.GET)
	public String assignUserStoryToUser(Model model,@PathVariable("pid") int pid,@PathVariable("usertype") String usertype) {
		
		List<User> developers;
		
		List<ProductBackLogUserStory> userStories = userStoryService.findUserStoryByProductId(pid);
		model.addAttribute("userStories", userStories);
		if(usertype.equals("developer")){
			 developers = userService.findUserByRoleId(1);
		}else{
			 developers = userService.findUserByRoleId(2);
		}
		
		model.addAttribute("developers", developers);
		model.addAttribute("pid", pid);
		model.addAttribute("usertype", usertype);
		
		model.addAttribute("page", "userStory/AssignUserStoryToDeveloper");
		return "Container";
	}
	
	@RequestMapping(value = "/assignuserstoriestodeveloperandtester/{usertype}/{pid}/{did}", method = RequestMethod.GET)
	public String assignUserStorytoEmployee(Model model,@PathVariable("pid") int pid,@PathVariable("did") int did,@PathVariable("usertype") String usertype) {
		
		
		List<ProductBackLogUserStory> userStories = userStoryService.findUnAssignedDeveloperUserStoryByProductId(pid,usertype);
		
		List<ProductBackLogUserStory> developerStories = userStoryService.findUserStoryByDeveloperId(did,usertype);
		
		model.addAttribute("userStories", userStories);
		model.addAttribute("developerStories", developerStories);
		model.addAttribute("devid", did);
		model.addAttribute("pid", pid);
		model.addAttribute("usertype", usertype);
		model.addAttribute("page", "userStory/AssignUserStoryToUsers");
		return "Container";
	}
	
	@RequestMapping(value = "/updateuserstoriestodeveloperandtester/{usertype}/{pid}/{uid}/{did}", method = RequestMethod.GET)
	public String updateUserStoryToDeveloper(Model model,@PathVariable("pid") int pid,@PathVariable("did") int did,@PathVariable("uid") int uid, @PathVariable("usertype") String usertype) {
		
		
		userStoryService.updateDeveloperAndTesterIdInUserStory(uid,did,pid,usertype);

		return "redirect:/userstory/assignuserstoriestodeveloperandtester/"+usertype+"/"+pid+"/"+did;
	}
	
	

}
