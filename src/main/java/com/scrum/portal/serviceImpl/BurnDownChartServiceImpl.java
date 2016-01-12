package com.scrum.portal.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.ProductBackLogUserStory;
import com.scrum.portal.dto.UserStoryEffortLog;
import com.scrum.portal.repositories.BurnDownChartRepository;
import com.scrum.portal.services.BurnDownChartService;

@Service
public class BurnDownChartServiceImpl implements BurnDownChartService {

	@Autowired
	private BurnDownChartRepository burnDownChartRepository;

	@Override
	public Map<Integer, Integer> getBurnDownData(int sprintID) {
		// TODO Auto-generated method stub

		List<Integer> listOfObjects = burnDownChartRepository.getProductBackLogObject(sprintID);
		StringBuffer queryBuilder = new StringBuffer("(");
		Integer usId;
		for (int i = 0; i < listOfObjects.size() - 1; i++) {
			usId = listOfObjects.get(i);
			queryBuilder.append(usId).append(",");

		}
		usId = listOfObjects.get(listOfObjects.size() - 1);
		queryBuilder.append(usId).append(")");
		System.out.println("Framed Query" + queryBuilder);

		List<Integer> totalEstimateList = burnDownChartRepository.getTotalEstimateEffort(sprintID);
		Integer totalEstimateEffortUS = 0;
		for (Integer effort : totalEstimateList) {
			totalEstimateEffortUS += effort;
		}

		System.out.println("totalEstimateEffortUS " + totalEstimateEffortUS);

		Integer maxDay = burnDownChartRepository.getMaxDay(sprintID);
		System.out.println("max days " + maxDay);

		List<UserStoryEffortLog> listOfUserLog = burnDownChartRepository.getUserEffortLogData(sprintID);

		System.out.println("listUserLog " + listOfUserLog.size());

		Map<Integer, Integer> listMap = new HashMap();

		for (int i = 1; i <= maxDay; i++) {
			int totalActualEffortPerDay = 0;

			for (int j = 1; j <= i; j++) 
			{
				for (UserStoryEffortLog userStoryEffortLog : listOfUserLog) 
				{
					if (userStoryEffortLog.getDay() == j)
						totalActualEffortPerDay += userStoryEffortLog.getActualEffort_Dev();

				}
				
			}
			totalActualEffortPerDay = totalEstimateEffortUS - totalActualEffortPerDay;
			System.out.println("final effort " + totalActualEffortPerDay);
			listMap.put(i, totalActualEffortPerDay);
		}

		System.out.println(listMap.size());

		return listMap;
	}

}
