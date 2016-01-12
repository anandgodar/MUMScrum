package com.scrum.portal.model;


public class UserStoryFormBean {
	
	private int id;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String description;
	private int developerid;
	private int testerid;
	private int developerestimatedtime;
	private int testerestimatedtime;
	private int developeractualtime;
	private int testeractualtime;
	
	
	private int releaseid;
	private int productid;
	private int sprintid;
	private int scrummasterid; 
	

	
	public int getScrummasterid() {
		return scrummasterid;
	}

	public void setScrummasterid(int scrummasterid) {
		this.scrummasterid = scrummasterid;
	}

	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeveloperid() {
		return developerid;
	}

	public void setDeveloperid(int developerid) {
		this.developerid = developerid;
	}

	public int getTesterid() {
		return testerid;
	}

	public void setTesterid(int testerid) {
		this.testerid = testerid;
	}

	public int getDeveloperestimatedtime() {
		return developerestimatedtime;
	}

	public void setDeveloperestimatedtime(int developerestimatedtime) {
		this.developerestimatedtime = developerestimatedtime;
	}

	public int getTesterestimatedtime() {
		return testerestimatedtime;
	}

	public void setTesterestimatedtime(int testerestimatedtime) {
		this.testerestimatedtime = testerestimatedtime;
	}

	public int getDeveloperactualtime() {
		return developeractualtime;
	}

	public void setDeveloperactualtime(int developeractualtime) {
		this.developeractualtime = developeractualtime;
	}

	public int getTesteractualtime() {
		return testeractualtime;
	}

	public void setTesteractualtime(int testeractualtime) {
		this.testeractualtime = testeractualtime;
	}


	public UserStoryFormBean()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReleaseid() {
		return releaseid;
	}

	public void setReleaseid(int releaseid) {
		this.releaseid = releaseid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getSprintid() {
		return sprintid;
	}

	public void setSprintid(int sprintid) {
		this.sprintid = sprintid;
	}

	
	

}
