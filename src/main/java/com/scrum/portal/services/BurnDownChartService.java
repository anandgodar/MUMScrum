package com.scrum.portal.services;

import java.util.Map;

public interface BurnDownChartService 
{
	
	public Map<Integer,Integer> getBurnDownData(int sprintID);

}
