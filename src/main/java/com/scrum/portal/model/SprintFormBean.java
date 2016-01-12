package com.scrum.portal.model;


public class SprintFormBean {

	
	private int id;
	private String name;
	private String description;
	private int releaseid;

	public int getReleaseid() {
		return releaseid;
	}

	public void setReleaseid(int releaseid) {
		this.releaseid = releaseid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
