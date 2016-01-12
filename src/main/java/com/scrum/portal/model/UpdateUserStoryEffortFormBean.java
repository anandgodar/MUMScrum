package com.scrum.portal.model;

public class UpdateUserStoryEffortFormBean 
{

	private int id; //for product backlog userstory table update

	private int employeeID;
	private int userStory_Id;
	private int actualEffort_Dev;
	private int actualEffort_Test;
	private int day;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getUserStory_Id() {
		return userStory_Id;
	}
	public void setUserStory_Id(int userStory_Id) {
		this.userStory_Id = userStory_Id;
	}
	public int getActualEffort_Dev() {
		return actualEffort_Dev;
	}
	public void setActualEffort_Dev(int actualEffort_Dev) {
		this.actualEffort_Dev = actualEffort_Dev;
	}
	public int getActualEffort_Test() {
		return actualEffort_Test;
	}
	public void setActualEffort_Test(int actualEffort_Test) {
		this.actualEffort_Test = actualEffort_Test;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	

}
