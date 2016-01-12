package com.scrum.portal.controllers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.repositories.BurnDownChartRepository;
import com.scrum.portal.services.BurnDownChartService;

@Controller
public class BurnDownChartController 
{
	
	@Autowired
	private BurnDownChartService burnDownChartService;
	
	@Autowired
	private BurnDownChartRepository burnDownChartRepository;
	
	@RequestMapping(value="burnDownChartData/{Id}", method=RequestMethod.GET)
	public String GetDataForBurnDownChart(@PathVariable("Id") int sprintId, Model model, HttpSession session)
	{
		
		Map<Integer,Integer> mapList = burnDownChartService.getBurnDownData(sprintId);
		model.addAttribute("listOfProductBackLog", mapList);
		session.setAttribute("list",mapList);
	
		int startingTotalEstimateEffort = 0;
		int currentTotalActualffort = 0;
		
		for (Map.Entry<Integer, Integer> entry : mapList.entrySet()) 
		{
			
			currentTotalActualffort = entry.getValue();
			
		}
		
		List<Integer> totalEstimateList = burnDownChartRepository.getTotalEstimateEffort(sprintId);
		Integer totalEstimateEffortUS = 0;
		for (Integer effort : totalEstimateList) {
			totalEstimateEffortUS += effort;
		}
		startingTotalEstimateEffort = totalEstimateEffortUS;
		System.out.println("startingTotalEstimateEffort "+ startingTotalEstimateEffort +" remainingTotalActualffort "+ currentTotalActualffort);
	
		
		int burnDownVelocity = (startingTotalEstimateEffort - currentTotalActualffort)/mapList.size();
		System.out.println("burnDownVelocity "+burnDownVelocity);
		
		int estimateProjectFinish = currentTotalActualffort/burnDownVelocity;
		System.out.println("estimateProjectFinish "+estimateProjectFinish);
		
		model.addAttribute("burnDownVelocity", burnDownVelocity);
		model.addAttribute("estimateProjectFinish", estimateProjectFinish);
		
		return "chart";
		
	}
	
}
